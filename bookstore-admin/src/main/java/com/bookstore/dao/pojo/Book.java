package com.bookstore.dao.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "book")
public class Book {
    /**
     * 书籍编号
     */
    @Id
    private Integer bid;

    /**
     * 书籍名
     */
    private String bname;

    /**
     * 书籍详情
     */
    private String detail;

    /**
     * 书籍价格
     */
    private String pirce;

    /**
     * 作者
     */
    private String writer;

    /**
     * 出版社
     */
    private String printer;

    /**
     * 出版日期
     */
    private Date date;

    /**
     * 类型
     */
    private String type;

    /**
     * 图片路径
     */
    private String image;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 获取书籍编号
     *
     * @return bid - 书籍编号
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * 设置书籍编号
     *
     * @param bid 书籍编号
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * 获取书籍名
     *
     * @return bname - 书籍名
     */
    public String getBname() {
        return bname;
    }

    /**
     * 设置书籍名
     *
     * @param bname 书籍名
     */
    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    /**
     * 获取书籍详情
     *
     * @return detail - 书籍详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置书籍详情
     *
     * @param detail 书籍详情
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * 获取书籍价格
     *
     * @return pirce - 书籍价格
     */
    public String getPirce() {
        return pirce;
    }

    /**
     * 设置书籍价格
     *
     * @param pirce 书籍价格
     */
    public void setPirce(String pirce) {
        this.pirce = pirce == null ? null : pirce.trim();
    }

    /**
     * 获取作者
     *
     * @return writer - 作者
     */
    public String getWriter() {
        return writer;
    }

    /**
     * 设置作者
     *
     * @param writer 作者
     */
    public void setWriter(String writer) {
        this.writer = writer == null ? null : writer.trim();
    }

    /**
     * 获取出版社
     *
     * @return printer - 出版社
     */
    public String getPrinter() {
        return printer;
    }

    /**
     * 设置出版社
     *
     * @param printer 出版社
     */
    public void setPrinter(String printer) {
        this.printer = printer == null ? null : printer.trim();
    }

    /**
     * 获取出版日期
     *
     * @return date - 出版日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置出版日期
     *
     * @param date 出版日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取图片路径
     *
     * @return image - 图片路径
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置图片路径
     *
     * @param image 图片路径
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}