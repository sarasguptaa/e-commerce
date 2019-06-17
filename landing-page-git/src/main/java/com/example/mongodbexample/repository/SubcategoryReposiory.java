package com.example.mongodbexample.repository;

import com.example.mongodbexample.entity.EntityClass;
import com.example.mongodbexample.entity.ProductClass;
import com.example.mongodbexample.entity.SubcategoryClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface SubcategoryReposiory extends MongoRepository<SubcategoryClass,String> {


    public SubcategoryClass findBySubcid(String subcid);
 // public ArrayList<SubcategoryClass> findBySubCid(String subcid);


}
