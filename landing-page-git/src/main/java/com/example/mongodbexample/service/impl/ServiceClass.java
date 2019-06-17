package com.example.mongodbexample.service.impl;

import com.example.mongodbexample.entity.EntityClass;
import com.example.mongodbexample.entity.ProductClass;
import com.example.mongodbexample.entity.SubcategoryClass;
import com.example.mongodbexample.repository.RepositoryInterface;
import com.example.mongodbexample.repository.SubcategoryReposiory;
import com.example.mongodbexample.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceClass implements ServiceInterface {

    @Autowired
    RepositoryInterface repositoryInterface;


    @Override
    public List<EntityClass> findAll() {
        return repositoryInterface.findAll();
    }

    @Override
    public EntityClass findByCid(String cid) {

        return repositoryInterface.findByCid(cid);
    }


    @Override
    public EntityClass insert(EntityClass entityClass) {
        return repositoryInterface.save(entityClass);
    }




//    @Override
//    public void changeDb() {
//        repositoryInterface.useDb();
//    }

   /* @Override
    public MyCollection1 insertOrUpdate(MyCollection1 entityClass) {
        if(entityClass.getPid()==null) {
            entityClass.setPid(UUID.randomUUID().toString());
            return repositoryInterface.insert(entityClass);
        }
        else return repositoryInterface.save(entityClass);
    }

    @Override
    public void delete(String employeeId) {
        repositoryInterface.delete(employeeId);
    }

    @Override
    public void deleteAll() {
        repositoryInterface.deleteAll();
    }

    @Override
    public boolean exists(String employeeId) {
        return repositoryInterface.exists(employeeId);
    }

    @Override
    public long count() {
        return repositoryInterface.count();
    }

    */
}
