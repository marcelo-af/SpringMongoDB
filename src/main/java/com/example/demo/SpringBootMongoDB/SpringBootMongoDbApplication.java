package com.example.demo.SpringBootMongoDB;

import java.text.SimpleDateFormat;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.demo.configurations.MongoDBConfigurations;
import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

@SpringBootApplication
public class SpringBootMongoDbApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootMongoDbApplication.class, args);
		try {
			AbstractApplicationContext context = new AnnotationConfigApplicationContext(MongoDBConfigurations.class);
			ProductService productService = context.getBean(ProductService.class);
			
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			for(Product product: productService.findAll()) {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("Quantity: " + product.getQuantity());
			System.out.println("Date: " + formatter.format(product.getDate()));
			System.out.println("Status " + product.isStatus());
            System.out.println("Brand Info");
            System.out.println("\tBrand Id: " + product.getBrand().getId());
            System.out.println("\tBrand Name: " + product.getBrand().getName());
            System.out.println("Colors: ");
            for(String color: product.getColors()) {
              System.out.println("\t" + color);	
            }
            System.out.println("========================================");
			}
			context.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
