package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/20 13:24
 * @Version 1.0.0
 * 验证码返回参数
 */
public class CodeResp {
    @ApiModelProperty("验证码返回参数")
    private String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
