package com.example.order_management.repository;

import com.example.order_management.entity.CartClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClass extends MongoRepository<CartClass,String > {

    public CartClass findByUserId(String id);
    public void deleteByUserId(String id);

}
