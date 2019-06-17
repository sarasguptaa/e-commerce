package com.example.mongodbexample.service;

import com.example.mongodbexample.entity.EntityClass;
import com.example.mongodbexample.entity.ProductClass;
import com.example.mongodbexample.entity.SubcategoryClass;

import java.util.ArrayList;
import java.util.List;

public interface ServiceInterface {
//    public List<EntityClass> findAll();
 //  public EntityClass findOne(String employeeId);
//    public EntityClass insertOrUpdate(EntityClass entityClass);
    public List<EntityClass> findAll();
    public EntityClass findByCid(String cid);
    public EntityClass insert(EntityClass entityClass);
    //public void changeDb();





    // public EntityClass insertOrUpdate(EntityClass entityClass);
//    public void delete(String employeeId);
  //  public void deleteAll();
 //   public boolean exists(String employeeId);
 //   public long count();
}
