package com.bookstore.response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户添加相应实体
 */
@Api("用户添加相应实体")
public class UserAddResp {
    @ApiModelProperty("用户添加返回结果")
    private int result;

    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
}
