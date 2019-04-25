package com.bookstore.dao.pojo;

import javax.persistence.*;

@Table(name = "book_order")
public class BookOrder {
    /**
     * 订单 ID
     */
    @Id
    private Integer oid;

    /**
     * 订单时间
     */
    private String date;

    /**
     * 订单名
     */
    private String oname;

    /**
     * 地址
     */
    private String adress;

    /**
     * 状态
     */
    private String status;

    /**
     * 用户 ID
     */
    private Integer uid;

    /**
     * 获取订单 ID
     *
     * @return oid - 订单 ID
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * 设置订单 ID
     *
     * @param oid 订单 ID
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /**
     * 获取订单时间
     *
     * @return date - 订单时间
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置订单时间
     *
     * @param date 订单时间
     */
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    /**
     * 获取订单名
     *
     * @return oname - 订单名
     */
    public String getOname() {
        return oname;
    }

    /**
     * 设置订单名
     *
     * @param oname 订单名
     */
    public void setOname(String oname) {
        this.oname = oname == null ? null : oname.trim();
    }

    /**
     * 获取地址
     *
     * @return adress - 地址
     */
    public String getAdress() {
        return adress;
    }

    /**
     * 设置地址
     *
     * @param adress 地址
     */
    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
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

    /**
     * 获取用户 ID
     *
     * @return uid - 用户 ID
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置用户 ID
     *
     * @param uid 用户 ID
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }
}