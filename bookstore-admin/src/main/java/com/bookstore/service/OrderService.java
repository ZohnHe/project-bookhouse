package com.bookstore.service;

import com.bookstore.dao.pojo.BookOrder;
import com.bookstore.dao.pojo.User;
import com.bookstore.domain.*;
import com.bookstore.dao.pojo.ext.UnionInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/21 15:19
 * @Version 1.0.0
 */
public interface OrderService {
    Integer addOrder(User user, AddOrderEntity addOrderEntity);

    Integer deleteOrder(DeleteOrderEntity deleteOrderEntity);

    Integer updateOrder(ModifyOrderEntity modifyOrderEntity);

    List<BookOrder> QueryAllOrderByOid(ShowMOrderEntity showMOrderEntity);


    PageInfo<UnionInfo> searchUnOrder(OrderQueryEntity orderQueryEntity);

    Integer getOrderCount();
}
