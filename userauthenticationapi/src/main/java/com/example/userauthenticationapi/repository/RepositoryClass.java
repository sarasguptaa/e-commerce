package com.example.userauthenticationapi.repository;

import com.example.userauthenticationapi.entity.EntityClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryClass extends CrudRepository<EntityClass,String> {

    public EntityClass findByEmailAdd(String name);

}