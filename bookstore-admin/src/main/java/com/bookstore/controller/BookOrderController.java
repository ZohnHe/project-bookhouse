package com.bookstore.controller;

import com.bookstore.common.BaseResponse;
import com.bookstore.dao.pojo.BookOrder;
import com.bookstore.dao.pojo.User;
import com.bookstore.domain.*;
import com.bookstore.domain.vo.BookOrderVo;
import com.bookstore.dao.pojo.ext.UnionInfo;
import com.bookstore.response.*;
import com.bookstore.service.OrderService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/21 10:13
 * @Version 1.0.0
 */
@Controller
@Api(tags="书籍订单模块")  //swagger分类标题注解
@RequestMapping(value = "/order")
public class BookOrderController {

    @Resource
    OrderService orderService;

    @ApiOperation(value = "添加订单")
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<AddOrderResp> addOrder(HttpServletRequest request, @RequestBody AddOrderEntity addOrderEntity){
        //获取到用户凭证session中的用户
        User user = (User)request.getSession().getAttribute("user");
        Integer orderId=orderService.addOrder(user, addOrderEntity);
        //返回订单号
        AddOrderResp addOrderResp = new AddOrderResp();
        addOrderResp.setOrderId(orderId);
        return new BaseResponse(addOrderResp);
    }

    @ApiOperation(value = "删除订单")
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<DeleteOrderResp> deleteOrder(@RequestBody DeleteOrderEntity deleteOrderEntity){

        Integer result=orderService.deleteOrder(deleteOrderEntity);
        DeleteOrderResp deleteOrderResp = new DeleteOrderResp();
        if(result==null||result==0){
            deleteOrderResp.setSuccess("0");
        }else{
            deleteOrderResp.setSuccess("1");
        }
        return new BaseResponse(deleteOrderResp);
    }

    @ApiOperation(value = "修改订单")
    @RequestMapping(value = "/ModifyOrder", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<ModifyOrderResp> ModifyOrder(@RequestBody ModifyOrderEntity modifyOrderEntity){

        Integer result=orderService.updateOrder(modifyOrderEntity);
        ModifyOrderResp modifyOrderResp = new ModifyOrderResp();
        if(result==null||result==0){
            modifyOrderResp.setSuccess("0");
        }else{
            modifyOrderResp.setSuccess("1");
        }
        return new BaseResponse(modifyOrderResp);
    }

    @ApiOperation(value = "点击修改订单后,所需要查询展示的3个数据(这个页面有方法已实现了)")
    @RequestMapping(value = "/ShowModifyOrder", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<ShowMOrderResp<BookOrderVo>> QueryAllOrderByOid(@RequestBody ShowMOrderEntity showMOrderEntity){
        // 查询所有
        List<BookOrder> list=orderService.QueryAllOrderByOid(showMOrderEntity);
        //属性拷贝,只输出3个参数
        ArrayList<BookOrderVo> data = new ArrayList<>();
        if(list!=null&&list.size()>0){
            for(BookOrder bookOrder:list){
                BookOrderVo bean = new BookOrderVo();
                try {
                    BeanUtils.copyProperties(bookOrder,bean);
                } catch (BeansException e) {
                    e.printStackTrace();
                }
                data.add(bean);
            }
        }
        ShowMOrderResp<BookOrderVo> showMOrderResp = new ShowMOrderResp(data);

        return new BaseResponse(showMOrderResp);
    }

    @ApiOperation(value = "联合查询订单,后台展示数据")
    @RequestMapping(value = "/searchUnOrder", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<OrderListResp<UnionInfo>> searchUnOrder(@RequestBody OrderQueryEntity orderQueryEntity){
        PageInfo<UnionInfo> list=orderService.searchUnOrder(orderQueryEntity);
        System.out.println(orderQueryEntity.getSearch()+"....");
        OrderListResp<UnionInfo> orderListResp = new OrderListResp(list.getList());

        orderListResp.setPageNum(orderQueryEntity.getPageNum());
        orderListResp.setPageSize(orderQueryEntity.getPageSize());
        orderListResp.setTotalRecord(list.getTotal());
        long totalPage=(orderListResp.getTotalRecord()+orderQueryEntity.getPageSize()-1)/orderQueryEntity.getPageSize();
        orderListResp.setTotalPage(totalPage);
        return new BaseResponse(orderListResp);
    }

    @ApiOperation(value = "管理员查询订单总数")
    @RequestMapping(value = "/getOrderCount", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<OrderCountResp> getOrderCount(){

        Integer count=orderService.getOrderCount();
        OrderCountResp orderCountResp = new OrderCountResp();
        orderCountResp.setOrderCount(count);
        return new BaseResponse(orderCountResp);
    }
}
