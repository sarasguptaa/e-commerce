package com.example.order_management.controller;

import com.example.order_management.entity.CartClass;
import com.example.order_management.entity.MailEntity;
import com.example.order_management.entity.OrderClass;
import com.example.order_management.entity.ProductClass;
import com.example.order_management.entityDto.CartDtoClass;
import com.example.order_management.service.OrderClassServiceInterface;
import com.example.order_management.service.ServiceInterface;
import com.example.order_management.service.impl.MailService;
import com.mongodb.util.JSON;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import net.minidev.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ControllerClass {

    @Autowired
    ServiceInterface serviceInterface;
    @Autowired
    OrderClassServiceInterface orderClassServiceInterface;

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    MailService service;

    public void sendMail(MailEntity mailEntity)
    {
        service.sendMail(mailEntity);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/saveCart")
    public ResponseEntity<CartClass> save(@RequestBody CartDtoClass cartDtoClass)
    {
        CartClass cartClass=new CartClass();
        BeanUtils.copyProperties(cartDtoClass,cartClass);
        String uid=cartDtoClass.getUserId();
        try{String tid=serviceInterface.findOne(uid).getTempId();
        cartClass.setTempId(tid);
        serviceInterface.save(cartClass);
        }
        catch (Exception e)
        {
            serviceInterface.save(cartClass);

        }
        return new ResponseEntity<CartClass>(cartClass,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/findCartWithId/{id}")
    public ResponseEntity<?> findCartWithId(@PathVariable("id")String id)
    {
        CartClass cartClass=serviceInterface.findOne(id);
        ArrayList<ProductClass> arr= (ArrayList<ProductClass>) cartClass.getProductClassList();
        for(ProductClass productClass:arr)
        {
            System.out.println("Previous price "+productClass.getPrice());
            String uri="http://172.16.26.33:8082//getPrice/"+productClass.getPid();
            try{
            RestTemplate restTemplate=new RestTemplate();
            String result=restTemplate.getForObject(uri,String.class);
            productClass.setPrice(Float.parseFloat(result));
            System.out.println("new price "+result);}
            catch (Exception e)
            {
                productClass.setPrice(productClass.getPrice());
            }

        }
        cartClass.setProductClassList(arr);
        return new ResponseEntity<>(cartClass,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteCartById/{id}")
    public void deleteCartById(@PathVariable("id") String id)
    {
        serviceInterface.deleteCartByUserId(id);

    }


    @RequestMapping(method = RequestMethod.GET,value = "/getOrderById/{uid}")
    public ResponseEntity<List<OrderClass>> getOrderById(@PathVariable("uid") String id){

        return new ResponseEntity<List<OrderClass>>(orderClassServiceInterface.findByUserId(id),HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.POST,value = "/saveOrder")
    public ResponseEntity<?> saveOrder(@RequestBody OrderClass orderClass) throws Exception
    {
        OrderClass orderClass1=orderClassServiceInterface.save(orderClass);
        deleteCartById(orderClass1.getUserId());

        String uri="http://localhost:8081/getEmail/"+orderClass1.getUserId();

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Object[]> responseEntity= restTemplate.getForEntity(uri,Object[].class);
        Object[] objects=responseEntity.getBody();
        MailEntity mailEntity=new MailEntity(String.valueOf(objects[0]),String.valueOf(objects[1]),"Your order has been placed");
        sendMail(mailEntity);


        return new ResponseEntity<OrderClass>(orderClass1,HttpStatus.OK);
    }


}
