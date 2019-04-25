package com.bookstore.response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息修改 响应实体
 */
@Api(value = "用户信息修改响应实体")
public class UserModifyResp {
    @ApiModelProperty("成功修改用户信息")
    private int result;

    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
}
