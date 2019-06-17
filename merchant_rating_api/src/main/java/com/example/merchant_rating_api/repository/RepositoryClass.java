package com.example.merchant_rating_api.repository;

import com.example.merchant_rating_api.entity.EntityClass;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface RepositoryClass extends CrudRepository<EntityClass,String> {
    public EntityClass findByNoOfProducts(int pro);
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update merchant_details set quantity_sold=:quantsold,stock=:stock,rating=:rating where mid=:mid ",nativeQuery = true)
    public void updateDetails(@Param("mid") String mid,@Param("stock") int stock, @Param("quantsold")int quantsold,@Param("rating") float rating);

}
