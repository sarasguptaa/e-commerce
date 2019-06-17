package com.example.merchant_rating_api.controller;


import com.example.merchant_rating_api.entity.EntityClass;
import com.example.merchant_rating_api.entityDto.EntityDto;
import com.example.merchant_rating_api.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080",allowedHeaders = "*")
@RestController
public class MainController {

    @Autowired
    ServiceInterface serviceInterface;

    @RequestMapping(method = RequestMethod.GET,value = "/getAll")
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<>(serviceInterface.getAllField(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getRating/{mid}")
    public String getRating(@PathVariable("mid") String mid)
    {
        EntityClass entityClass=serviceInterface.getOne(mid);
        if(entityClass!=null)
        {
            return String.valueOf(entityClass.getRating());
        }
        else return "No Such Record Found";

    }

    @RequestMapping(method = RequestMethod.GET,value = "/getMerchantName/{mid}")
    public String getName(@PathVariable("mid") String mid)

    {
        EntityClass entityClass=serviceInterface.getOne(mid);
        if(entityClass!=null)
        {
            return entityClass.getMerchantName();
        }
        else return "Not Found";
    }



    @RequestMapping(method = RequestMethod.GET,value = "/updateRating")
    public void updateRating(@RequestBody EntityDto entityDto)
    {
        String tempMid=entityDto.getMid();
        EntityClass entityClass=serviceInterface.getOne(tempMid);
        if(entityClass!=null)
        {
            int noprod=entityClass.getNoOfProducts();
            int initstock=entityClass.getInitialAvail();
            int stock=entityClass.getStockLeft();
            int quantsold=entityClass.getQuantitySold();

            int stockSold=entityDto.getStockLeft();
            float newRating=((float)noprod/(float)64)+((float)stock-(float)stockSold)/(float)initstock+((((float)stockSold+(float)quantsold)/(float)initstock)*(float)3);
            int newquantsold=quantsold+stockSold;
            int newStock=stock-stockSold;
            serviceInterface.updateDetails(tempMid,newStock,newquantsold,newRating);
        }
    }

}
