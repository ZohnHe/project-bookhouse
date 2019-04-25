package com.bookstore.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Table;
import javax.validation.constraints.Min;

/**
 *
 *<p>Title:BookVo</p>
 *<p>Description: 返回给前端的渲染实体 </p>
 *
 * @author Administrator
 * @date 2019/2/20 20:56
 */
@Table(name = "book")
public class BookVo {
    /**
     * 书籍编号
     */
    @ApiModelProperty("ID")
    private Integer bid;

    /**
     * 书籍名
     */
    @ApiModelProperty("书名")
    @NotEmpty(message = "图书名称不能为空!")
    private String bname;

    /**
     * 书籍价格
     */
    @ApiModelProperty("价格")
    @Min(value=0,message = "图书价格不能为空!")
    private String pirce;

    /**
     * 书籍图片
     */

    @ApiModelProperty("图片")
    private String image;
    /**
     * 作者
     */
    @ApiModelProperty("作者")
    private String writer;

    /**
     * 出版社
     */
    @ApiModelProperty("出版社")
    private String printer;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;

    /**
     * 库存
     */
    @ApiModelProperty("库存")
    private Integer stock;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
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

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}