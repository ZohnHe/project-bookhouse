package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/20 9:21
 * @Version 1.0.0
 * 注册返回参数
 */
public class RegisterResp {
    @ApiModelProperty("成功=1,失败=0")
    private String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
