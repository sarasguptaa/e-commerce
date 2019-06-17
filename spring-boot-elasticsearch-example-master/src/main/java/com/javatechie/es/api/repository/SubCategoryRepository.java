package com.javatechie.es.api.repository;

import com.javatechie.es.api.model.SubCategory;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubCategoryRepository extends ElasticsearchRepository<SubCategory,String> {

    List<SubCategory> findBysubname(String subname);
}
