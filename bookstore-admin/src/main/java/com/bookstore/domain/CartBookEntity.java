package com.bookstore.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CartBookEntity implements Serializable {

    private String username;

    private String img;

    private String name;
    private String author;
    private String printer;
    private String price;
    private Integer num;
    @ApiModelProperty("同本书的总价")
    private String all;
    public CartBookEntity(String img, String name, String author, String printer, String price, Integer num, String all) {
        this.img = img;
        this.name = name;
        this.author = author;
        this.printer = printer;
        this.price = price;
        this.num = num;
        this.all = all;
    }

    public CartBookEntity() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
