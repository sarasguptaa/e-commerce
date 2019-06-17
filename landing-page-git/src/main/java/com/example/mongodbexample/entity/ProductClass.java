package com.example.mongodbexample.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = ProductClass.COLLECTION_NAME)

public class ProductClass {

    public static final String COLLECTION_NAME="ProductNew";
    @Id
private String id;
    @Field(value = "pid")
    private String pid;
    private String pname;
    private String price;
    private String desc;
    private String stock;
    private String mid;
    private String subcid;
    private String imgurl;


    @Override
    public String toString() {
        return "ProductClass{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", price='" + price + '\'' +
                ", desc='" + desc + '\'' +
                ", stock='" + stock + '\'' +
                ", mid='" + mid + '\'' +
                ", subcid='" + subcid + '\'' +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String getCollectionName() {
        return COLLECTION_NAME;
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
