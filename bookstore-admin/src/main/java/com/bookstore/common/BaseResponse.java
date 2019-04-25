package com.bookstore.common;


import com.bookstore.common.constant.ResponseCode;


/**
 *
 *<p>Title:BaseResponse</p>
 *<p>Description:传输到客户端的公共响应类</p>
 *
 * @author Administrator
 * @date 2019/2/19 16:56
 */
public class BaseResponse<T> implements java.io.Serializable {

    private String code = ResponseCode.OK.getCode();;
    private String msg = ResponseCode.OK.getDesc();
    private T data;



    public BaseResponse(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
