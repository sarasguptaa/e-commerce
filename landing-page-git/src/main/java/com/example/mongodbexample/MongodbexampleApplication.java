package com.example.mongodbexample;

import com.example.mongodbexample.service.ServiceInterface;
import com.example.mongodbexample.service.impl.ServiceClass;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MongodbexampleApplication extends AbstractMongoConfiguration {

	@Autowired
	static ServiceInterface serviceInterface;

	public static void main(String[] args) {

		SpringApplication.run(MongodbexampleApplication.class, args);

		//serviceInterface.changeDb();
	}

//	private static void getRating()
//	{
//		final String url = "http://172.16.26.35:8001/getRating/{mid}";
//
//		RestTemplate restTemplate = new RestTemplate();
//		String result = restTemplate.getForObject(url, String.class);
//
//		System.out.println(result);
//	}

	@Override
	protected String getDatabaseName() {
		return "DemoDb";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost",27017);
	}
}
