package com.example.order_management.service.impl;

import com.example.order_management.entity.OrderClass;
import com.example.order_management.repository.OrderRepository;
import com.example.order_management.service.OrderClassServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderClassImpl implements OrderClassServiceInterface {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderClass save(OrderClass orderClass) {
        return orderRepository.save(orderClass);
    }

    @Override
    public OrderClass findByUserId(String id) {
        return orderRepository.findByUserId(id);
    }
}
