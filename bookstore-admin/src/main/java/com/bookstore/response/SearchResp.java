package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

public class SearchResp<T> {
    @ApiModelProperty("响应结果")
    private int result;

    @ApiModelProperty("查询的响应数据")
    private T data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
