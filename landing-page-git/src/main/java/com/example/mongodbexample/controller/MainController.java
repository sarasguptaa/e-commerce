package com.example.mongodbexample.controller;

import com.example.mongodbexample.entity.EntityClass;
import com.example.mongodbexample.entity.ProductClass;
import com.example.mongodbexample.entity.SubcategoryClass;
import com.example.mongodbexample.entityDto.EntityDtoClass;
import com.example.mongodbexample.entityDto.ProductDto;
import com.example.mongodbexample.entityDto.SubcategoryDtoClass;
import com.example.mongodbexample.service.ProductService;
import com.example.mongodbexample.service.ServiceInterface;
import com.example.mongodbexample.service.SubcatService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class MainController {

    @Autowired
    ServiceInterface serviceInterface;


    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    public ResponseEntity<?> insert(@RequestBody EntityClass entityClass) {
        EntityClass entityClass1 = serviceInterface.insert(entityClass);
        return new ResponseEntity<>(entityClass, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getAllCat")
    public ResponseEntity<List<EntityClass>> getAllCat() {
        List<EntityClass> collection1s = serviceInterface.findAll();
        for (EntityClass a : collection1s) {
            System.out.println(a);
        }
        return new ResponseEntity<List<EntityClass>>(collection1s, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getOneCatDet/{cid}")
    public ResponseEntity<?> getOneCatDet(@PathVariable("cid") String cid) {
        EntityClass entityClass = serviceInterface.findByCid(cid);
        EntityDtoClass entityDtoClass = new EntityDtoClass();
        if (entityClass == null) {
            return new ResponseEntity<String>("Not Found", HttpStatus.OK);
        }
        BeanUtils.copyProperties(entityClass, entityDtoClass);
        return new ResponseEntity<EntityDtoClass>(entityDtoClass, HttpStatus.OK);
    }


    @Autowired
    SubcatService subcatService;

    @RequestMapping(method = RequestMethod.GET, value = "/getOneSubcatDet/{subcid}")
    public ResponseEntity<?> getOneSubcatDet(@PathVariable("subcid") String subcid) {
        SubcategoryClass subcategoryClass = subcatService.findBySubcid(subcid);
        SubcategoryDtoClass subcategoryDtoClass = new SubcategoryDtoClass();
        if (subcategoryClass == null) {
            return new ResponseEntity<String>("Not Found", HttpStatus.OK);
        }
        BeanUtils.copyProperties(subcategoryClass, subcategoryDtoClass);
        return new ResponseEntity<SubcategoryDtoClass>(subcategoryDtoClass, HttpStatus.OK);
    }


/*
    @RequestMapping(method = RequestMethod.GET,value = "/getOneSubcatDetail/{subcid}")
    public ResponseEntity<?> getOneSubcatDetail(@PathVariable ("subcid") String subcid)
    {
        List<SubcategoryClass> subcategoryClassList=new ArrayList<SubcategoryClass>();
                subcategoryClassList=subcatService.findBySubCid(subcid);

        List<SubcategoryDtoClass> subcategoryDtoClass=new ArrayList<SubcategoryDtoClass>();
        if(subcategoryClassList==null)
        {
            return new ResponseEntity<String>("Not Found", HttpStatus.OK);
        }
        BeanUtils.copyProperties(subcategoryClassList,subcategoryDtoClass);


        ArrayList<String> mIdList = subcatService.extractPid(subcategoryClassList);
        ArrayList<String> x=new ArrayList<>();
        mIdList.forEach((li)->{
            x.add(subcatService.getProd(li));
        });
        return new ResponseEntity<List<SubcategoryClass>>(subcategoryClassList,HttpStatus.OK);
    }

*/


   /* @RequestMapping(method = RequestMethod.GET, value="/ab")
    public ResponseEntity<?> ab(){
        List<SubcategoryClass> subcategoryClassList=subcatService.getOneProdEach();
        for(SubcategoryClass a:subcategoryClassList)
        {
            System.out.println(a);
        }
        ArrayList<String> mIdList = subcatService.extractPid(subcategoryClassList);
        ArrayList<String> x=new ArrayList<>();
        mIdList.forEach((li)->{
            x.add(subcatService.getProd(li));
        });
        return new ResponseEntity<List<SubcategoryClass>>(subcategoryClassList, HttpStatus.OK);
    }

*/


    @RequestMapping(method = RequestMethod.GET, value = "/getAllSubcat")
    public ResponseEntity<List<SubcategoryClass>> getAllSubcat() {
        List<SubcategoryClass> collection1s = subcatService.findAll();
        for (SubcategoryClass a : collection1s) {
            System.out.println(a);
        }
        return new ResponseEntity<List<SubcategoryClass>>(collection1s, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/insertS")
    public ResponseEntity<?> insertS(@RequestBody SubcategoryClass subcategoryClass) {
        SubcategoryClass subcategoryClass1 = subcatService.insert(subcategoryClass);
        return new ResponseEntity<>(subcategoryClass, HttpStatus.OK);
    }

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllProdWithSamePid/{pid}")
    public ResponseEntity<List<ProductDto>> getAllProdWithSamePid(@PathVariable("pid") String pid) {
        List<ProductClass> productClassList = new ArrayList<ProductClass>();
        productClassList = productService.findByPid(pid);

        List<ProductDto> productDto = new ArrayList<ProductDto>();


        if (productClassList == null) {
            return null;
        }
        BeanUtils.copyProperties(productClassList, productDto);

        for (ProductClass productClass : productClassList) {
            //  ProductClass productClass=new ProductClass();
            ProductDto productDto1 = new ProductDto();
            BeanUtils.copyProperties(productClass, productDto1);
            productDto1.setMerchantRating(productService.getRating(productClass.getMid()));
            productDto1.setMerchantName(productService.getMerchantName(productClass.getMid()));
            productDto.add(productDto1);
        }
        return new ResponseEntity<List<ProductDto>>(productDto, HttpStatus.OK);

    }

    @CrossOrigin(origins = "*")

    @RequestMapping(method = RequestMethod.GET, value = "/getOneProdDet/{pid}")
    public ResponseEntity<ProductDto> getOneProdDet(@PathVariable("pid") String pid) {
        List<ProductClass> productClassList = new ArrayList<ProductClass>();
        productClassList = productService.findByPid(pid);

        ProductDto productDto = new ProductDto();

        if (productClassList == null) {
            return null;
        }
        BeanUtils.copyProperties(productClassList, productDto);


        ArrayList<String> mIdList = productService.extractMid(productClassList);
        ArrayList<String> x = new ArrayList<>();
        mIdList.forEach((li) -> {
            x.add(productService.getRating(li));
        });

        // productService.maxRating(x);


        float max = 0f;
        ProductClass productClass1 = new ProductClass();
        for (ProductClass productClass : productClassList) {
            float temp = Float.parseFloat(productService.getRating(productClass.getMid()));
            if (max < temp) {
                max = temp;
                productClass1 = productClass;
            }
        }
        System.out.println(productClass1.getId() + " " + productClass1.getMid());
//        List<ProductDto> productDtoList=new ArrayList<ProductDto>();
//        productDtoList.setMerchantRating(productService.getRating(productDto.getMid()));
//        ProductDto productDtoo=new ProductDto();
//        BeanUtils.copyProperties(productClassList,productDto);
//        productDtoo.setMerchantRating(productService.getRating(productDtoo.getMid()));
//        productDtoo.setMerchantName(productService.getMerchantName(productDtoo.getMid()));
//        productDto.add(productDtoo);



//        Map<List<String>,List<String>> myMap = new HashMap<List<String>, List<String>>();
//        ArrayList<String> mIdList = productService.extractMid(productClassList);
//        ArrayList<String> x=new ArrayList<>();
//        mIdList.forEach((li)->{
//            x.add(productService.getRating(li));
//        });
//        String a;
//        myMap.put(x,mIdList);
//        x.forEach((li)->{
//            if(li==productService.maxRating(x))
//
//            });


        productService.maxRating(x);


        ProductDto productDto1=new ProductDto();
        BeanUtils.copyProperties(productClass1, productDto1);
        productDto1.setMerchantRating((productService.getRating(productClass1.getMid())));
        productDto1.setMerchantName(productService.getMerchantName(productClass1.getMid()));


        return new ResponseEntity<ProductDto>(productDto1, HttpStatus.OK);
    }

    HashSet<Integer> generateRandom()
    {
        HashSet<Integer> arr=new HashSet<Integer>();
        Random random=new Random();
        while(arr.size()!=15)
        {
            arr.add(random.nextInt(30));
        }
        return arr;
    }



    @RequestMapping(method = RequestMethod.GET,value = "/getAllProd")
    public ResponseEntity<List<ProductDto>> getAllProd()
    {

        List<ProductClass> collection1s=productService.findAll();
        for(ProductClass a:collection1s)
        {
            System.out.println(a);
        }

        HashSet<Integer> arr=generateRandom();
        HashSet<Integer> arr2=new HashSet<>();
        List<ProductDto> collection1=new ArrayList<>();
        int j=0;
        for(Integer i:arr)
        {
            if(j==15)
                break;
            int temp= Integer.parseInt(collection1s.get(i).getPid());
            if(arr2.add(temp))
            {
                ProductDto productDto=new ProductDto();
                BeanUtils.copyProperties(collection1s.get(i),productDto);
                productDto.setMerchantRating(productService.getRating(productDto.getMid()));
                productDto.setMerchantName(productService.getMerchantName(productDto.getMid()));
                collection1.add(productDto);
                j++;
            }
        }

        return new ResponseEntity<List<ProductDto>>(collection1,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getPrice/{pid}")
    public ResponseEntity<?> getPrice(@PathVariable ("pid") String pid)
    {
        List<ProductClass> productClassList=new ArrayList<ProductClass>();
        productClassList = productService.findByPid(pid);
        return new ResponseEntity<>(productClassList.get(0).getPrice(),HttpStatus.OK);

    }




/*
    @RequestMapping(method = RequestMethod.GET,value = "/exists/{eid}")
    public ResponseEntity<Boolean> exists(@PathVariable("eid") String eid)
    {
        return new ResponseEntity<Boolean>(serviceInterface.exists(eid),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{eid}")
    public ResponseEntity<Boolean> delete(@PathVariable("eid") String eid)
    {
        serviceInterface.delete(eid);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteAll")
    public String deleteAll()
    {
        serviceInterface.deleteAll();
        return "DONE";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/count")
    public long count()
    {
        return serviceInterface.count();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/addOrUpdate")
    public ResponseEntity<?> addOrUpdate(@RequestBody MyCollection1 entityDtoClass)
    {
        MyCollection1 entityClass=new MyCollection1();
        BeanUtils.copyProperties(entityDtoClass,entityClass);
        serviceInterface.insertOrUpdate(entityClass);
        return new ResponseEntity<MyCollection1>(entityClass,HttpStatus.OK);
    }


*/


    }


