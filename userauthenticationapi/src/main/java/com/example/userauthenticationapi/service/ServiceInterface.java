package com.example.userauthenticationapi.service;

import com.example.userauthenticationapi.entity.EntityClass;

import java.util.List;

public interface ServiceInterface {

    public EntityClass save(EntityClass entityClass);
    public EntityClass findOne(String id);
    public EntityClass findByEmailAdd(String email);

}
