package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, String>{

}
