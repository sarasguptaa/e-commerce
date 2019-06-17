package com.example.order_management.repository;

import com.example.order_management.entity.OrderClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderClass,String> {
    public OrderClass findByUserId(String id);
}
