package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/22 10:59
 * @Version 1.0.0
 */
public class OrderListResp<T> {
    @ApiModelProperty("总记录数")
    private long totalRecord;

    @ApiModelProperty("当前页")
    private int pageNum;

    @ApiModelProperty("分页数")
    private long pageSize;

    @ApiModelProperty("总页数")
    private long totalPage;

    @ApiModelProperty("订单列表")
    private T data;

    public OrderListResp(T data) {
        this.data = data;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
