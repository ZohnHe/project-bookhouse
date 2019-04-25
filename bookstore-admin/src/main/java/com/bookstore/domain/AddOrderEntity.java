package com.bookstore.domain;

import com.bookstore.dao.pojo.BookOrder;
import com.bookstore.dao.pojo.OrderDetail;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/21 14:34
 * @Version 1.0.0
 * 添加订单接收参数实体
 */
public class AddOrderEntity {

    @ApiModelProperty("收货人")
    private String oname;

    @ApiModelProperty("收货地址")
    private String adress;
    @ApiModelProperty("订单状态")
    private String status;
    @ApiModelProperty("订单详情列表")
    private List<OrderDetail> orderDetails;

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
