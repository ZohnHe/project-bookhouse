package com.bookstore.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/20 13:22
 * @Version 1.0.0
 * 验证码接受参数
 */
public class CodeEntity {
    @ApiModelProperty("验证码")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
