package com.javatechie.es.api.repository;


import com.javatechie.es.api.dto.ProductDto;
import com.javatechie.es.api.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product,String> {

    List<Product> findBypname(String pname);
    List<Product> findBydesc(String desc);
}
