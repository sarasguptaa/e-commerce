package com.example.userauthenticationapi.service.impl;

import com.example.userauthenticationapi.entity.EntityClass;
import com.example.userauthenticationapi.repository.RepositoryClass;
import com.example.userauthenticationapi.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements ServiceInterface {

    @Autowired
    RepositoryClass repositoryClass;

    @Override
    public EntityClass save(EntityClass entityClass) {
        return repositoryClass.save(entityClass);
    }

    @Override
    public EntityClass findOne(String id) {
        return repositoryClass.findOne(id);
    }

    @Override
    public EntityClass findByEmailAdd(String email) {
        return repositoryClass.findByEmailAdd(email);
    }
}
