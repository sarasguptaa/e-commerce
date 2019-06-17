package com.example.order_management.service;

import com.example.order_management.entity.CartClass;

import java.util.List;

public interface ServiceInterface {
    public List<CartClass> findAll();
    public CartClass findOne(String id);
    public CartClass save(CartClass cartClass);
    public boolean check(String id);
    public void deleteCartByUserId(String id);
}
