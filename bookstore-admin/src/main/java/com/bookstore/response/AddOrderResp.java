package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/21 15:10
 * @Version 1.0.0
 * 添加完订单返回订单号
 */
public class AddOrderResp {
    @ApiModelProperty("返回订单号")
    private Integer orderId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
