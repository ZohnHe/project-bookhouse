package com.bookstore.response;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 *<p>Title:LoginManagerResponse</p>
 *<p>Description:管理员登陆响应数据</p>
 *
 * @author Administrator
 * @date 2019/2/19 16:58
 */
public class LoginManagerResponse {
    @ApiModelProperty("成功状态：1=成功 0=失败")
    private String success;

    @ApiModelProperty("管理员用户名")
    private String username;

    @ApiModelProperty("返回消息")
    private String msg;

    @ApiModelProperty("缓存ID登陆凭证")
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
