package com.example.order_management.controller;

import com.example.order_management.entity.CartClass;
import com.example.order_management.entity.MailEntity;
import com.example.order_management.entity.OrderClass;
import com.example.order_management.entity.ProductClass;
import com.example.order_management.entityDto.CartDtoClass;
import com.example.order_management.service.OrderClassServiceInterface;
import com.example.order_management.service.ServiceInterface;
import com.example.order_management.service.impl.MailService;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerClass {

    @Autowired
    ServiceInterface serviceInterface;
    @Autowired
    OrderClassServiceInterface orderClassServiceInterface;

    @Autowired
    MailService service;

    @RequestMapping(method = RequestMethod.GET,value = "/sendMail")
    public void sendMail(MailEntity mailEntity)
    {
        service.sendMail(mailEntity);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/saveCart")
    public ResponseEntity<CartClass> save(@RequestBody CartClass cartClass)
    {
        CartClass cartClass1=serviceInterface.save(cartClass);
        return new ResponseEntity<CartClass>(cartClass1,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/findCartWithId/{id}")
    public ResponseEntity<?> findCartWithId(@PathVariable("id")String id)
    {
        CartClass cartClass=serviceInterface.findOne(id);
        ArrayList<ProductClass> arr= (ArrayList<ProductClass>) cartClass.getProductClassList();
        for(ProductClass productClass:arr)
        {
            System.out.println("Previous price "+productClass.getPrice());
            String uri="http://172.16.29.8:8082//getPrice/"+productClass.getPid();
            RestTemplate restTemplate=new RestTemplate();
            String result=restTemplate.getForObject(uri,String.class);
            productClass.setPrice(Float.parseFloat(result));
            System.out.println("new price "+result);
        }
        cartClass.setProductClassList(arr);
        return new ResponseEntity<>(cartClass,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteCartById/{id}")
    public void deleteCartById(@PathVariable("id") String id)
    {
        serviceInterface.deleteCartByUserId(id);

    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateCart")
    public ResponseEntity<?> updateCart(@RequestBody CartDtoClass cartDtoClass)
    {
        if(serviceInterface.check(cartDtoClass.getUserId()))
            System.out.println("found");
        CartClass cartClass=serviceInterface.findOne(cartDtoClass.getUserId());
        cartClass.setProductClassList(cartDtoClass.getProductClassList());
        cartClass.setQuantity(cartDtoClass.getQuantity());
        CartClass cartClass1=serviceInterface.save(cartClass);
        return new ResponseEntity<CartClass>(cartClass1,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getOrderById/{uid}")
    public ResponseEntity<?> getOrderById(@PathVariable("uid") String id){
        OrderClass orderClass=orderClassServiceInterface.findByUserId(id);
        return new ResponseEntity<>(orderClass,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/saveOrder")
    public ResponseEntity<?> saveOrder(@RequestBody OrderClass orderClass)
    {
        OrderClass orderClass1=orderClassServiceInterface.save(orderClass);
        deleteCartById(orderClass.getUserId());
        String uri="http://localhost:8081/getEmail/"+orderClass1.getUserId();
        //System.out.println(uri);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Object[]> responseEntity= restTemplate.getForEntity(uri,Object[].class);
        Object[] objects=responseEntity.getBody();
        MailEntity mailEntity=new MailEntity(String.valueOf(objects[0]),String.valueOf(objects[1]),"Your order has been placed");
        sendMail(mailEntity);
        return new ResponseEntity<OrderClass>(orderClass1,HttpStatus.OK);
    }

}
