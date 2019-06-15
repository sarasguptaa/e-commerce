package com.example.userauthenticationapi.mainController;

import com.example.userauthenticationapi.entity.EntityClass;
import com.example.userauthenticationapi.entityDto.EntityDtoClass;
import com.example.userauthenticationapi.service.ServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    ServiceInterface serviceInterface;
    @CrossOrigin(origins = "http://localhost:8080")


    @RequestMapping(method = RequestMethod.POST,value = "/signup")
    public ResponseEntity<?> saveData(@RequestBody EntityDtoClass entityDtoClass)
    {

        EntityClass entityClass=new EntityClass();
        if(serviceInterface.findByEmailAdd(entityClass.getEmailAdd())!=null)
        {BeanUtils.copyProperties(entityDtoClass,entityClass);
        EntityClass entityClass1=serviceInterface.save(entityClass);
        return new ResponseEntity<EntityClass>(entityClass1, HttpStatus.OK);}
        else return new ResponseEntity<String>("Already Exists",HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:8080")

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public  ResponseEntity<?> findBy(@RequestBody EntityDtoClass email)
    {
        EntityClass entityClass=serviceInterface.findByEmailAdd(email.getEmailAdd());
        if(entityClass.getPassword().equals(email.getPassword()))
        {
            return new ResponseEntity<>(entityClass,HttpStatus.OK);
        }
        else return null;
    }

}
