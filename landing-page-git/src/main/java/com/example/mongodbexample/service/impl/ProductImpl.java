package com.example.mongodbexample.service.impl;


import com.example.mongodbexample.entity.ProductClass;
import com.example.mongodbexample.repository.ProductRepository;
import com.example.mongodbexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductClass> findByPid(String pid) {

        return productRepository.findByPid(pid);
    }

    @Override
    public List<ProductClass> findAll() {

        return productRepository.findAll();
    }


    @Override
    public List<ProductClass> findAllByPid(String pid) {
        return productRepository.findAllByPid(pid);
    }


    @Override
    public ProductClass findMidByPid(String pid) {

        return productRepository.findMidByPid(pid);
    }

    @Override
    public ArrayList<String> extractMid(List<ProductClass> list){

        ArrayList<String> st=new ArrayList<>();
        list.forEach((o)->{
            st.add(o.getMid());
        });
        return st;
    }

    @Override
    public String getRating(String mid) {
        final String url = "http://172.16.29.20:8001/getRating/"+mid;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
//        System.out.println(result);
        return result;
    }

    @Override
    public String getMerchantName(String mid) {
        final String url = "http://172.16.29.20:8001/getMerchantName/"+mid;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
//        System.out.println(result);
        return result;
    }


    @Override
    public String maxRating(List<String> list){
        ArrayList<Float> intList= new ArrayList<>();
        for(String s : list) intList.add(Float.valueOf(s));

        Float max=0f;

        for (Float i : intList) {

            if (max < i) {
                max = i;
            }
        }
        System.out.println(" \n"+max);
        return Float.toString(max);
    }
}