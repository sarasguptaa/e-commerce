package com.example.order_management.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = CartClass.COLLECTION_NAME)
public class CartClass {
    public static final String COLLECTION_NAME="cart_collection";

    @Id
    private String tempId;
    @Field(value = "user_id")
    private String userId;
    @Field(value = "products")
    private List<ProductClass> productClassList;

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

    public List<ProductClass> getProductClassList() {
        return productClassList;
    }

    public void setProductClassList(List<ProductClass> productClassList) {
        this.productClassList = productClassList;
    }

}
