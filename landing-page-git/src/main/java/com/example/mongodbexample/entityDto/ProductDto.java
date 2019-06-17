package com.example.mongodbexample.entityDto;

import org.springframework.data.mongodb.core.mapping.Field;

public class ProductDto {

    @Field(value = "pid")
    private String pid;
    private String pname;
    private String price;
    private String desc;
    private String stock;
    private String mid;
    private String subcid;
    private String imgurl;
    private String merchantRating;
    private String merchantName;

    public String getMerchantRating() {
        return merchantRating;
    }

    public void setMerchantRating(String merchantRating) {
        this.merchantRating = merchantRating;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getSubcid() {
        return subcid;
    }

    public void setSubcid(String subcid) {
        this.subcid = subcid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
