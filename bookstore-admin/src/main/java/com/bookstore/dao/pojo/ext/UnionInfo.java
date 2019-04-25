package com.bookstore.dao.pojo.ext;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/22 10:27
 * @Version 1.0.0
 * 联合查询的实体
 */
public class UnionInfo {
    private Integer oid;
    private String date;
    private String oname;
    private String adress;
    private String status;
    private Integer uid;
    private String bname;
    private String image;
    private String pirce;
    private Integer bookNum;
    private Double totalPirce;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPirce() {
        return pirce;
    }

    public void setPirce(String pirce) {
        this.pirce = pirce;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public Double getTotalPirce() {
        return totalPirce;
    }

    public void setTotalPirce(Double totalPirce) {
        this.totalPirce = totalPirce;
    }
}
