package com.example.mongodbexample.service;

import com.example.mongodbexample.entity.EntityClass;
import com.example.mongodbexample.entity.ProductClass;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    public List<ProductClass> findByPid(String pid);
    public List<ProductClass> findAll();
    public List<ProductClass> findAllByPid(String pid);
    public ProductClass findMidByPid(String pid);
    public ArrayList<String> extractMid(List<ProductClass> list);
    public String getRating(String mid);

    public String maxRating(List<String> list);
    public String getMerchantName(String mid);



    }
