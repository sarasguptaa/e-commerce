package com.example.merchant_rating_api.service;

import com.example.merchant_rating_api.entity.EntityClass;

import java.util.List;

public interface ServiceInterface {

    public Iterable<?> getAllField();
    public EntityClass getOne(String mid);
    public EntityClass getByNoOfProd(int pro);
    public void updateDetails( String mid, int stock, int quantsold,float rating);

}
