package com.example.order_management;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@SpringBootApplication


public class OrderManagementApplication extends AbstractMongoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);

	}

	@Override
	protected String getDatabaseName() {
		return "CartDb";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost",27017);
	}
}
