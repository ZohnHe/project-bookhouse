package com.bookstore.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 管理员登录实体
 */
@Api(value = "管理员登录")
public class ManagerEntity {
    @ApiModelProperty("管理员用户名")
    @NotEmpty(message = "管理员用户名不能为空!")
    private String username ;

    @ApiModelProperty("管理员密码")
    @NotEmpty(message = "管理员密码不能为空!")
    private String password ;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
