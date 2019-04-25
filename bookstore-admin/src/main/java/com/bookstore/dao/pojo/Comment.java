package com.bookstore.dao.pojo;

import javax.persistence.*;

@Table(name = "comment")
public class Comment {
    /**
     * 评价 ID
     */
    @Id
    private Integer cid;

    /**
     * 书籍 ID
     */
    private Integer bid;

    /**
     * 用户名
     */
    private String uname;

    /**
     * 评价日期
     */
    private String date;

    /**
     * 评价内容
     */
    private String content;

    /**
     * 获取评价 ID
     *
     * @return cid - 评价 ID
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * 设置评价 ID
     *
     * @param cid 评价 ID
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * 获取书籍 ID
     *
     * @return bid - 书籍 ID
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * 设置书籍 ID
     *
     * @param bid 书籍 ID
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * 获取用户名
     *
     * @return uname - 用户名
     */
    public String getUname() {
        return uname;
    }

    /**
     * 设置用户名
     *
     * @param uname 用户名
     */
    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    /**
     * 获取评价日期
     *
     * @return date - 评价日期
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置评价日期
     *
     * @param date 评价日期
     */
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    /**
     * 获取评价内容
     *
     * @return content - 评价内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评价内容
     *
     * @param content 评价内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}