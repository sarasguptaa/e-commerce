package com.example.merchant_rating_api.entityDto;

public class EntityDto {

    private static final String TABLE_NAME="merchant_details";

    private String mid;
    private String merchantName;
    private int noOfProducts;
    private int quantitySold;
    private int stockLeft;
    private float rating;

    public int getInitialAvail() {
        return initialAvail;
    }

    public void setInitialAvail(int initialAvail) {
        this.initialAvail = initialAvail;
    }

    private int initialAvail;

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
