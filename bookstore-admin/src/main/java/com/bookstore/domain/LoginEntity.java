package com.bookstore.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/19 8:36
 * @Version 1.0.0
 */
public class LoginEntity {
  /*  @ApiModelProperty("手机号")
    @NotEmpty(message = "用户名/邮箱不能为空")
    @Length(min = 2,message = "用户名/邮箱不能少于2")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;*/

    @ApiModelProperty("手机号/邮箱")
    private String emailphone;

    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

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
}
