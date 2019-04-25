package com.bookstore.service.impl;

import com.bookstore.common.constant.Status;
import com.bookstore.dao.mapping.BookMapper;
import com.bookstore.dao.mapping.BookOrderMapper;
import com.bookstore.dao.mapping.OrderDetailMapper;
import com.bookstore.dao.mapping.ext.BookMapperExt;
import com.bookstore.dao.mapping.ext.BookOrderMapperExt;
import com.bookstore.dao.pojo.Book;
import com.bookstore.dao.pojo.BookOrder;
import com.bookstore.dao.pojo.OrderDetail;
import com.bookstore.dao.pojo.User;
import com.bookstore.domain.*;
import com.bookstore.dao.pojo.ext.UnionInfo;
import com.bookstore.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/21 15:19
 * @Version 1.0.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    BookOrderMapper bookOrderM;
    @Resource
    BookOrderMapperExt bookOrderMapperExt;
    @Resource
    OrderDetailMapper orderDetailM;
    @Resource
    BookMapper bookMapper;
    @Resource
    BookMapperExt bookMapperExt;

    /**
     * 添加到订单表,和详情表
     *
     * @param user
     * @param orderEntity
     * @return
     */
    @Override
    public Integer addOrder(User user, AddOrderEntity orderEntity) {
        //添加订单的时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        //订单号/还是收货人好呢,暂时设为收货人好了
        //String oname= UUID.randomUUID().toString();
        //插入订单表
        BookOrder bookOrder = new BookOrder();
        bookOrder.setDate(dateStr);
        bookOrder.setOname(orderEntity.getOname());
        bookOrder.setAdress(orderEntity.getAdress());
        bookOrder.setStatus(Status.UN_DO);
        if (user.getUid() != null) {
            bookOrder.setUid(user.getUid());  //等到登陆时才能设置,不然报错

        }else{
            bookOrder.setUid(1);
        }
        Integer ret = bookOrderM.insertSelective(bookOrder);
        System.out.println(ret + ".........shi");
        if (ret == null) {
            return null;
        }
        //通过时间查订单表的id
        Example example = new Example(BookOrder.class);
        example.createCriteria().andEqualTo("date", dateStr);
        List<BookOrder> list = bookOrderM.selectByExample(example);
        Integer orderId = 0;
        if (list != null && list.size() > 0) {
            orderId = list.get(0).getOid();
        }
        //插入订单详情表
        for (OrderDetail od : orderEntity.getOrderDetails()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setBookId(od.getBookId());
            orderDetail.setBookNum(od.getBookNum());
            orderDetail.setOrderId(orderId);
            orderDetail.setStatus(Status.UN_COMMENT);
            Integer ret1 = orderDetailM.insertSelective(orderDetail);
            if (ret1 == null) {
                return null;
            }
            //减少book表的库存
            Integer stock = null;
            List<Book> blist = bookMapperExt.getBookStockById(od.getBookId());
            if (blist != null && blist.size() > 0) {
                stock = blist.get(0).getStock();
            }
            Integer newStock = stock - od.getBookNum();
            if (newStock < 0) {
                return null;
            }
            Book book = new Book();
            book.setBid(od.getBookId());
            book.setStock(newStock);
            Integer ret2 = bookMapper.updateByPrimaryKeySelective(book);
            if (ret2 == null) {
                return null;
            }
        }

        return orderId;
    }

    /**
     * 根据订单id删除订单,和该订单对应的详情表信息(可批量删除)
     *
     * @param deleteOrderEntity
     * @return
     */
    @Override
    public Integer deleteOrder(DeleteOrderEntity deleteOrderEntity) {
        Integer result = 0;
        Example example = new Example(BookOrder.class);
        HashSet<String> set = new HashSet<>();
        for (String oid : deleteOrderEntity.getOids()) {
            set.add(oid);
        }
        example.createCriteria().andIn("oid", set);
        result = bookOrderM.deleteByExample(example);
        if (result == null || result == 0) {
            return null;
        }
        System.out.println("--------------");
        Example example1 = new Example(OrderDetail.class);
        example1.createCriteria().andIn("orderId", set);
        result = orderDetailM.deleteByExample(example1);
        if (result == null || result == 0) {
            return null;
        }
        return result;
    }

    /**
     * 根据oid修改3个数据
     *
     * @param modifyOrderEntity
     * @return
     */
    @Override
    public Integer updateOrder(ModifyOrderEntity modifyOrderEntity) {
        Integer result = bookOrderMapperExt.updateOrderByOid(modifyOrderEntity.getOid()
                , modifyOrderEntity.getOname()
                , modifyOrderEntity.getAdress()
                , modifyOrderEntity.getStatus());
        if (result == null || result == 0) {
            return null;
        }
        return result;
    }

    /**
     * 通过订单id查询该订单所有信息(不包括详情)
     *
     * @param showMOrderEntity
     * @return
     */
    @Override
    public List<BookOrder> QueryAllOrderByOid(ShowMOrderEntity showMOrderEntity) {
        Example example = new Example(BookOrder.class);
        example.createCriteria().andEqualTo("oid", showMOrderEntity.getOrderId());
        List<BookOrder> list = bookOrderM.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }

    /**
     * 联合查询
     *
     * @param orderQueryEntity
     * @return
     */
    @Override
    public PageInfo<UnionInfo> searchUnOrder(OrderQueryEntity orderQueryEntity) {
        PageHelper.startPage(orderQueryEntity.getPageNum(), orderQueryEntity.getPageSize());
        List<UnionInfo> list = bookOrderMapperExt.searchUn(orderQueryEntity.getSearch());
        if (list != null && list.size() > 0) {
            //设置每个详情对象的总价
            for (UnionInfo unionInfo : list) {
                unionInfo.setTotalPirce(unionInfo.getBookNum() * Double.parseDouble(unionInfo.getPirce()));
            }
        }

        return new PageInfo<UnionInfo>(list);
    }

    /**
     * 管理员查询订单的总数
     *
     * @return
     */
    @Override
    public Integer getOrderCount() {
        Example example = new Example(BookOrder.class);
        example.createCriteria().andEqualTo("oid");
        Integer count = bookOrderM.selectCountByExample(example);
        return count;
    }


}
