package com.example.order_management.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = OrderClass.COLLECTION_NAME)
public class OrderClass {

    public static final String COLLECTION_NAME="order_table";

    @Id
    private String tempId;
    @Field(value = "user_id")
    private String userId;
    @Field(value="orderList")
    private ProductClass productClass;
    @Field(value = "address")
    private String address;

    public static String getCollectionName() {
        return COLLECTION_NAME;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ProductClass getProductClass() {
        return productClass;
    }

    public void setProductClass(ProductClass productClass) {
        this.productClass = productClass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
