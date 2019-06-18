package com.example.order_management.service.impl;

import com.example.order_management.entity.OrderClass;
import com.example.order_management.repository.OrderRepository;
import com.example.order_management.service.OrderClassServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderClassImpl implements OrderClassServiceInterface {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public OrderClass save(OrderClass orderClass) {
        return orderRepository.save(orderClass);
    }

    @Override
    public List<OrderClass> findByUserId(String id) {
        return orderRepository.findByUserId(id);
        //return (ArrayList<OrderClass>) mongoTemplate.find(Query.query(Criteria.where("userId").is(id)),OrderClass.class);
    }
}
