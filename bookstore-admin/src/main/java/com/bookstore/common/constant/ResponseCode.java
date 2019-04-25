package com.bookstore.common.constant;

/**
 *  全局返回编码定义
 *
 */
public enum ResponseCode {

    OK("200","正常"),
    FAIL("500","网络异常!");

    private String code;
    private String desc;

    private ResponseCode(String code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }

}
