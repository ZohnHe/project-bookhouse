package com.bookstore.domain.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/21 20:22
 * @Version 1.0.0
 */
public class BookOrderVo {
    @ApiModelProperty("订单id")
    private Integer oid;
    @ApiModelProperty("收货人")
    private String oname;
    @ApiModelProperty("地址")
    private String adress;
    @ApiModelProperty("订单状态")
    private String status;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
