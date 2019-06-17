package com.example.mongodbexample.service;

import com.example.mongodbexample.entity.EntityClass;
import com.example.mongodbexample.entity.ProductClass;
import com.example.mongodbexample.entity.SubcategoryClass;

import java.util.ArrayList;
import java.util.List;

public interface SubcatService {
 //  public ArrayList<SubcategoryClass> findBySubCid(String subcid);
    public List<SubcategoryClass> findAll();
    public SubcategoryClass insert(SubcategoryClass subcategoryClass);
  //  public List<SubcategoryClass>getOneProdEach();
  public String getProd(String pid) ;
 //   public ArrayList<String> extractPid(List<SubcategoryClass> list);

    public SubcategoryClass findBySubcid(String subcid);



}
