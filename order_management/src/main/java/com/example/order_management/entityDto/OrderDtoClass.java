package com.example.order_management.entityDto;

import com.example.order_management.entity.ProductClass;

import java.util.List;

public class OrderDtoClass {
    private String tempId;
    private String userId;
    private List<ProductClass> productClassList;
    private String Address;

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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
