package com.example.mongodbexample.repository;

import com.example.mongodbexample.entity.EntityClass;
import com.example.mongodbexample.entity.ProductClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface ProductRepository extends MongoRepository<ProductClass, String> {


    public ArrayList<ProductClass> findByPid(String pid);
    public List<ProductClass> findAllByPid(String pid);
    public ProductClass findMidByPid(String pid);







}
