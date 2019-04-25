package com.bookstore.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/21 17:40
 * @Version 1.0.0
 * 删除定好接收实体
 */
public class DeleteOrderEntity {
    @ApiModelProperty("订单号数组")
    private String[] oids;

    public String[] getOids() {
        return oids;
    }

    public void setOids(String[] oids) {
        this.oids = oids;
    }
}
