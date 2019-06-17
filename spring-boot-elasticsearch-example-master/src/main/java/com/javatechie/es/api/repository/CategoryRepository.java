package com.javatechie.es.api.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.javatechie.es.api.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ElasticsearchRepository<Category, String>{

	List<Category> findBycname(String cname);

}
