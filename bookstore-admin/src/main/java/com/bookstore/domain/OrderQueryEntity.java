package com.bookstore.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/22 10:43
 * @Version 1.0.0
 */
public class OrderQueryEntity {
    @ApiModelProperty("当前页")
    private int pageNum;
    @ApiModelProperty("每页数量")
    private int pageSize;
    @ApiModelProperty("搜索关键词,订单号搜索")
    private Integer search;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSearch() {
        return search;
    }

    public void setSearch(Integer search) {
        this.search = search;
    }
}
