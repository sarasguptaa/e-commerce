package com.example.mongodbexample.repository;


import com.example.mongodbexample.entity.EntityClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInterface extends MongoRepository<EntityClass,String> {

//    @Query(value = "use DemoDb")
//    public void useDb();

    public EntityClass findByCid(String cid);


}
