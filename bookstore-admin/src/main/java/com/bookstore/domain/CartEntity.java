package com.bookstore.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 购物车数据承载
 */
@Api
public class CartEntity {
    @ApiModelProperty("用户登录名")
    private String username;

    @ApiModelProperty("购物车书本和书本数量")
    private List<CartBookEntity> books;

    @ApiModelProperty("购物车总价")
    private String allPrice;

    public CartEntity() {
    }

    public CartEntity(String username, List<CartBookEntity> books, String allPrice) {
        this.username = username;
        this.books = books;
        this.allPrice = allPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CartBookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<CartBookEntity> books) {
        this.books = books;
    }

    public String getAllPrice() {
        return allPrice;
    }

    public void setPrice(String allPrice) {
        this.allPrice = allPrice;
    }
}
