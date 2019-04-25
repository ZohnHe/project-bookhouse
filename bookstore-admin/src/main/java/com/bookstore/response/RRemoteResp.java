package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/20 0:01
 * @Version 1.0.0
 * 远程校验 返回参数
 */
public class RRemoteResp {

    @ApiModelProperty("远程校验,返回的值")
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
