package com.bookstore.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 添加用户请求实体
 */
@Api(value = "添加用户请求实体")
public class UserAddEntity {

    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    private String uname;

    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty("性别")
    @NotEmpty(message = "性别不能为空")
    private String gender;

    @ApiModelProperty("邮箱")
    @NotEmpty(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("盐值")
    @NotEmpty(message = "盐值不能为空")
    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
