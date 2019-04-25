package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/21 17:51
 * @Version 1.0.0
 * 删除订单返回实体
 */
public class DeleteOrderResp {
    @ApiModelProperty("成功=1,失败=0")
    private String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
