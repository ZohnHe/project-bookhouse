package com.bookstore.response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/21 19:24
 * @Version 1.0.0
 * 修改订单返回的参数
 */
public class ModifyOrderResp {
    @ApiModelProperty("成功=1,失败=0")
    private String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
