package com.bookstore.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

/**
 *  图书列表请求输入参数
 *
 */

public class BooksDeleteEntity {

    @ApiModelProperty("需要删除的图书ID列表")
    @Size(min=1,message="图书ID不能为空!")
    private String[] booksIds;

    public String[] getBooksIds() {
        return booksIds;
    }
    public void setBooksIds(String[] booksIds) {
        this.booksIds = booksIds;
    }
}
