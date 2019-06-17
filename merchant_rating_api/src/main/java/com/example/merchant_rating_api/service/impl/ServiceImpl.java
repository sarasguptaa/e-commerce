package com.example.merchant_rating_api.service.impl;

import com.example.merchant_rating_api.entity.EntityClass;
import com.example.merchant_rating_api.repository.RepositoryClass;
import com.example.merchant_rating_api.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements ServiceInterface {

    @Autowired
    RepositoryClass repositoryClass;

    @Override
    public Iterable<?> getAllField() {
        return repositoryClass.findAll();
    }

    @Override
    public EntityClass getOne(String mid) {
        return repositoryClass.findOne(mid);
    }

    @Override
    public EntityClass getByNoOfProd(int pro) {
        return repositoryClass.findByNoOfProducts(pro);
    }

    @Override
    public void updateDetails(String mid, int stock, int quantsold, float rating) {
        repositoryClass.updateDetails(mid,stock,quantsold,rating);
    }
}
