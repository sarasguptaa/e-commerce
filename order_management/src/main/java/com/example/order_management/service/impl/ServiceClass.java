package com.example.order_management.service.impl;

import com.example.order_management.entity.CartClass;
import com.example.order_management.repository.RepositoryClass;
import com.example.order_management.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClass implements ServiceInterface {
    @Autowired
    RepositoryClass repositoryClass;

    @Override
    public List<CartClass> findAll() {
        return repositoryClass.findAll();
    }

    @Override
    public CartClass findOne(String id) {
        return repositoryClass.findByUserId(id);
    }

    @Override
    public CartClass save(CartClass cartClass) {
        return repositoryClass.save(cartClass);
    }

    @Override
    public boolean check(String id) {
        return repositoryClass.exists(id);
    }

    @Override
    public void deleteCartByUserId(String id) {
        repositoryClass.deleteByUserId(id);
    }
}
