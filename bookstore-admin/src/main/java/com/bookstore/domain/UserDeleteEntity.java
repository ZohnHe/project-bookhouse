package com.bookstore.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

/**
 * 删除用户实体
 */
@Api(value = "删除用户请求实体")
public class UserDeleteEntity {
    @ApiModelProperty("成功删除的用户记录数")
    @Size(min=1,message="用户ID不能为空!")
    private String[] userIds;

    public String[] getUserIds() {
        return userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }
}
