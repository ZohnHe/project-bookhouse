package com.bookstore.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/19 23:51
 * @Version 1.0.0
 * 远程检验接受参数
 */

public class RegisterRemoteEntity {
    @ApiModelProperty("手机号/邮箱")
    //@NotEmpty(message = "不能为空")
    private String emailphone;

    public String getEmailphone() {
        return emailphone;
    }

    public void setEmailphone(String emailphone) {
        this.emailphone = emailphone;
    }
}
