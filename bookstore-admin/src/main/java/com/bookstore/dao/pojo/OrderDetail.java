package com.bookstore.dao.pojo;

import javax.persistence.*;

@Table(name = "order_detail")
public class OrderDetail {
    /**
     * 订单详情 ID
     */
    @Id
    private Integer id;

    /**
     * 订单 ID
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 书籍 ID
     */
    @Column(name = "book_id")
    private Integer bookId;

    /**
     * 书籍数量
     */
    @Column(name = "book_num")
    private Integer bookNum;

    /**
     * 状态
     */
    private String status;

    /**
     * 获取订单详情 ID
     *
     * @return id - 订单详情 ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单详情 ID
     *
     * @param id 订单详情 ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单 ID
     *
     * @return order_id - 订单 ID
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单 ID
     *
     * @param orderId 订单 ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取书籍 ID
     *
     * @return book_id - 书籍 ID
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * 设置书籍 ID
     *
     * @param bookId 书籍 ID
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * 获取书籍数量
     *
     * @return book_num - 书籍数量
     */
    public Integer getBookNum() {
        return bookNum;
    }

    /**
     * 设置书籍数量
     *
     * @param bookNum 书籍数量
     */
    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}