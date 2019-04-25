package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/22 13:47
 * @Version 1.0.0
 * 查询订单总数返回实体
 */
public class OrderCountResp {
    @ApiModelProperty("总订单数")
    private Integer orderCount;

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }
}
