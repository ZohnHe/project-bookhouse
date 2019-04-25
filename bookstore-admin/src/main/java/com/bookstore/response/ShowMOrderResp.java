package com.bookstore.response;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/21 20:19
 * @Version 1.0.0
 * 点击修改订单后,返回的参数实体
 */
public class ShowMOrderResp<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ShowMOrderResp(T data) {
        this.data = data;
    }
}
