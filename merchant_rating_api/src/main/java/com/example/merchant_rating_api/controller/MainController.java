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



    @RequestMapping(method = RequestMethod.GET,value = "/updateRating/{mid}/{quantity}")
    public String updateRating(@PathVariable ("mid")String mid,@PathVariable("quantity") String quantity)
    {
        String tempMid=mid;
        float quant= Float.parseFloat(quantity);
        EntityClass entityClass=serviceInterface.getOne(tempMid);
        if(entityClass!=null)
        {
            float maxStock= Float.parseFloat(serviceInterface.maxStock());
            float stockUpdated=entityClass.getStockLeft()-quant;
            float rating;
            if(maxStock==0f)
            {
                maxStock= quant;
                rating=1f;
            }
            else{
                maxStock+=Float.valueOf(quantity);
                rating=quant/maxStock;

            }
            serviceInterface.updateDetails(tempMid,(int)stockUpdated,Integer.parseInt(quantity),rating);
            return "saveCart";
        }
        else
            return "Merchant Not Found";
    }

}
