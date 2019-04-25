package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/19 9:12
 * @Version 1.0.0
 */
public class LoginResp {
    @ApiModelProperty("成功状态=1, 失败状态=0")
    private String success;
    @ApiModelProperty("返回消息")
    private String msg;
    @ApiModelProperty("缓存id")
    private String sessionId;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
