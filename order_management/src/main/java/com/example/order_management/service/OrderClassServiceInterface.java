package com.example.order_management.service;

import com.example.order_management.entity.OrderClass;

import java.util.ArrayList;
import java.util.List;

public interface OrderClassServiceInterface {
    public OrderClass save(OrderClass orderClass);
    public List<OrderClass> findByUserId(String id);
}
