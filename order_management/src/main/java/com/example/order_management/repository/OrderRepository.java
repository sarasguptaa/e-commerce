package com.example.order_management.repository;

import com.example.order_management.entity.OrderClass;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<OrderClass,String> {
    public List<OrderClass> findByUserId(String id);

}
