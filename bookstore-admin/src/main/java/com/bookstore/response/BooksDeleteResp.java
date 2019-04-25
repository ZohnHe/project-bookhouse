package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

public class BooksDeleteResp {

    @ApiModelProperty("成功删除的图书记录数")
    private int result;

    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
}
