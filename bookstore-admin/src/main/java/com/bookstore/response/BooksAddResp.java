package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

public class BooksAddResp {

    @ApiModelProperty("成功添加的商品记录数")
    private int result;

    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
}
