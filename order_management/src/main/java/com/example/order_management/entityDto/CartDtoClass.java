package com.example.order_management.entityDto;

import com.example.order_management.entity.ProductClass;

import java.util.List;

public class CartDtoClass {
    private String userId;
    private List<ProductClass> productClassList;

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
