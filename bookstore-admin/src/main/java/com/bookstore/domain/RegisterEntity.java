package com.bookstore.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/20 9:16
 * @Version 1.0.0
 * 注册接受参数
 */
public class RegisterEntity {
    @ApiModelProperty("手机号/邮箱")
    @NotEmpty(message = "不能为空")
    private String emailphone;
    @NotEmpty(message = "不能为空")
    @ApiModelProperty("密码")
    private String password;
    @NotEmpty(message = "不能为空")
    @ApiModelProperty("接收盐值")
    private String salt;

    public String getEmailphone() {
        return emailphone;
    }

    public void setEmailphone(String emailphone) {
        this.emailphone = emailphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
