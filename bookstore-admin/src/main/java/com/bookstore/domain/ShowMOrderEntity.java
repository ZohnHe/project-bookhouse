package com.bookstore.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/21 20:14
 * @Version 1.0.0
 * 点击修改订单后,展示要修改的信息的接收实体
 */
public class ShowMOrderEntity {
    @ApiModelProperty("订单id")
    private Integer orderId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
