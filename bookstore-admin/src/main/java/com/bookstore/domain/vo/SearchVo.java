package com.bookstore.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

public class SearchVo {

    /**
     * 书籍 ID
     */
    @ApiModelProperty("书ID")
    private Integer bid;

    /**
     * 书籍名
     */
    @ApiModelProperty("书名")
    private String bname;

    /**
     * 书籍价格
     */
    @ApiModelProperty("价格")
    private String pirce;

    /**
     * 作者
     */
    @ApiModelProperty("作者")
    private String writer;

    /**
     * 图片
     */
    @ApiModelProperty("图片")
    private String image;


    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getBid() {
        return bid;
    }


    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getPirce() {
        return pirce;
    }

    public void setPirce(String pirce) {
        this.pirce = pirce;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
