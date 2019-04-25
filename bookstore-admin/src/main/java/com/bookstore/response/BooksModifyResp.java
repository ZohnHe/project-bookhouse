package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

public class BooksModifyResp {

    @ApiModelProperty("成功修改的图书记录数")
    private int result;

    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
}
