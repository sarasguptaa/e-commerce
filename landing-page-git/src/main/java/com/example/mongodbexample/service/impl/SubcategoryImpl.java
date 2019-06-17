package com.example.mongodbexample.service.impl;

import com.example.mongodbexample.entity.EntityClass;
import com.example.mongodbexample.entity.SubcategoryClass;
import com.example.mongodbexample.repository.SubcategoryReposiory;
import com.example.mongodbexample.service.ServiceInterface;
import com.example.mongodbexample.service.SubcatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class SubcategoryImpl implements SubcatService {

    @Autowired
    SubcategoryReposiory subcategoryReposiory;


//    @Override
//    public ArrayList<SubcategoryClass> findBySubCid(String subcid){
//        return subcategoryReposiory.findBySubCid(subcid);
//    }



 @Override
    public SubcategoryClass findBySubcid(String subcid){
        return subcategoryReposiory.findBySubcid(subcid);
    }


    @Override
    public List<SubcategoryClass> findAll() {
        return subcategoryReposiory.findAll();
    }

    @Override
    public SubcategoryClass insert(SubcategoryClass subcategoryClass) {
        return subcategoryReposiory.save(subcategoryClass);
    }


    @Override
    public String getProd(String pid) {
        final String url = "http://172.16.26.42:8082/getOneProdDet/"+pid;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
//        System.out.println(result);
        return result;
    }
//
//    @Override
//    public ArrayList<String> extractPid(List<SubcategoryClass> list){
//
//        ArrayList<String> st=new ArrayList<>();
//        list.forEach((o)->{
//    //        st.add(o.getPid());
//        });
//        return st;
//    }



//    @Override
//    public List<SubcategoryClass>getOneProdEach(){
//        ArrayList<String> list=new ArrayList<String>();
//        forEach
//
//    }
}
