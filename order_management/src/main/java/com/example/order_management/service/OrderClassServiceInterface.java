package com.example.order_management.service;

import com.example.order_management.entity.OrderClass;

public interface OrderClassServiceInterface {
    public OrderClass save(OrderClass orderClass);
    public OrderClass findByUserId(String id);
}
