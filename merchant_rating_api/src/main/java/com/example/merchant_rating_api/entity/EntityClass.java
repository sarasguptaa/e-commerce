package com.example.merchant_rating_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=EntityClass.TABLE_NAME)
public class EntityClass {
    public static final String TABLE_NAME="merchant_details";


    @Id
    @Column(name = "mid")
    private String mid;
    @Column(name = "name")
    private String merchantName;
    @Column(name = "no_products")
    private int noOfProducts;
    @Column(name="quantity_sold")
    private int quantitySold;
    @Column(name="stock")
    private int stockLeft;
    @Column(name = "rating")
    private float rating;
    @Column(name="init_avail")
    private int initialAvail;

    public int getInitialAvail() {
        return initialAvail;
    }

    public void setInitialAvail(int initialAvail) {
        this.initialAvail = initialAvail;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public int getNoOfProducts() {
        return noOfProducts;
    }

    public void setNoOfProducts(int noOfProducts) {
        this.noOfProducts = noOfProducts;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public int getStockLeft() {
        return stockLeft;
    }

    public void setStockLeft(int stockLeft) {
        this.stockLeft = stockLeft;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
