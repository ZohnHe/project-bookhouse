package com.bookstore.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 前端搜索实体
 */
@Api(value = "前端搜索实体")
public class SearchEntity {
    @ApiModelProperty(value = "搜索关键字")
    private String keywords;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
