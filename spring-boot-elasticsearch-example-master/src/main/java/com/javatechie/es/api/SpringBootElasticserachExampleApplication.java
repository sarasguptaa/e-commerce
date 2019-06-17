package com.javatechie.es.api;

import java.util.*;

import com.javatechie.es.api.dto.ProductDto;
import com.javatechie.es.api.model.Product;
import com.javatechie.es.api.model.SubCategory;
import com.javatechie.es.api.repository.ProductRepository;
import com.javatechie.es.api.repository.SubCategoryRepository;
import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javatechie.es.api.model.Category;
import com.javatechie.es.api.repository.CategoryRepository;
import org.springframework.web.client.RestTemplate;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders.*;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class SpringBootElasticserachExampleApplication {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/saveCategory")
	public int saveCategory(@RequestBody List<Category> categories) {
		categoryRepository.saveAll(categories);
		return categories.size();
	}

	@PostMapping("/saveSubCategory")
	public int saveSubCategory(@RequestBody List<SubCategory> subCategories) {
		subCategoryRepository.saveAll(subCategories);
		return subCategories.size();
	}

	@PostMapping("/saveProduct")
	public void saveProduct(@RequestBody List<Product> products){
		List<Product> list= (List<Product>) productRepository.saveAll(products);
		System.out.println(list.size());
		//return products.size();
	}



	@GetMapping("/findAllCate")
	public Iterable<Category> findAllCategory() {
		return categoryRepository.findAll();
	}

	@GetMapping("/findAllSubCat")
	public Iterable<SubCategory> findAllSubCat() {

	    return subCategoryRepository.findAll();
	}

	@GetMapping("/findAllProd")
	public Iterable<Product> findAllProduct() {
		return productRepository.findAll();
	}




	@GetMapping("/findByCategoryName/{cname}")
	public List<Category> findByCategoryName(@PathVariable("cname") String cName) {
		return categoryRepository.findBycname(cName);
	}


    @CrossOrigin(origins = "*")
	@GetMapping("/findBySubCategoryName/{subname}")
	public List<SubCategory> findBySubCategoryName(@PathVariable("subname") String subName){
		return subCategoryRepository.findBysubname(subName);
	}


	//@GetMapping(value = {"/findByProductName/{pname}"})
	//public List<Product> findByProductName(String pName)
	//{

	//	return productRepository.findBypname(pName);
	//}

    @CrossOrigin(origins = "*")
	@GetMapping(value = "/search/{searchQuery}")
	public ResponseEntity<ArrayList<ProductDto>> searchProducts(@PathVariable("searchQuery") String searchQuery)
	{
        System.out.println(searchQuery);
		List<Product> list1=productRepository.findBypname(searchQuery);
		List<Product> l2=productRepository.findBydesc(searchQuery);
		ArrayList<ProductDto> productDtoSet=new ArrayList<>();
		for (Product product:list1)
		{
			ProductDto productDto=new ProductDto();
			BeanUtils.copyProperties(product,productDto);
            productDto.setRating(Float.parseFloat(hitter(product.getMid())));
			productDto.setmName(hitterMerchantName(product.getMid()));
			productDtoSet.add(productDto);
		}
		for(Product product:l2)
		{
			ProductDto productDto=new ProductDto();
			BeanUtils.copyProperties(product,productDto);
            productDto.setRating(Float.parseFloat(hitter(product.getMid())));
			productDto.setmName(hitterMerchantName(product.getMid()));
			productDtoSet.add(productDto);
		}


		int i=0;
		while(i<productDtoSet.size())
		{
			String pid=productDtoSet.get(i).getPid();
			String mid=productDtoSet.get(i).getMid();
			for(int j=i+1;j<productDtoSet.size();j++){
				if(pid.equals(productDtoSet.get(j).getPid())&&mid.equals(productDtoSet.get(j).getMid()))
				{
					productDtoSet.remove(j);
				}
			}
			i++;
		}

            return new ResponseEntity<ArrayList<ProductDto>>(productDtoSet,HttpStatus.OK);
//        float max=0f;
//        Iterator iterator=productDtoSet.iterator();
//		ProductDto maxProductDto= (ProductDto) iterator.next();
//		return new ResponseEntity<ProductDto>(maxProductDto, HttpStatus.OK);
		/*for(ProductDto productDto:productDtoSet)
        {
            float temp=Float.parseFloat(hitter(productDto.getMid()));
            if(temp>max)
            {
                max=temp;
                maxProductDto=productDto;
            }
        }

        return maxProductDto;*/

	}


	@GetMapping("/findByProductDescription/{desc}")
	public List<Product> findByProductDescription(@PathVariable("desc") String desc)
	{

		String ptryname;
		ProductDto productDto=new ProductDto();
		ptryname=productDto.getDesc();
		org.elasticsearch.index.query.QueryBuilders.matchPhrasePrefixQuery();
		return productRepository.findBydesc(desc);
	}








	@DeleteMapping("/deleteAll")
	public void deleteAll(){
		categoryRepository.deleteAll();
		productRepository.deleteAll();
		subCategoryRepository.deleteAll();
	}

    public String hitter(String id){
	    final String uri="http://172.16.29.20:8001/getRating/"+id;
        RestTemplate restTemplate=new RestTemplate();
        String result=restTemplate.getForObject(uri,String.class);
        return result;
    }


	public String hitterMerchantName(String id){
		final String uri="http://172.16.29.20:8001/getMerchantName/"+id;
		RestTemplate restTemplate=new RestTemplate();
		String result1=restTemplate.getForObject(uri,String.class);
		return result1;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticserachExampleApplication.class, args);
	}
}
