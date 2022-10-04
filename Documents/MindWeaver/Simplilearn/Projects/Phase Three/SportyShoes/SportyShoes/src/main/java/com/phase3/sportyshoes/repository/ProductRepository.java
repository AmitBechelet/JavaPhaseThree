package com.phase3.sportyshoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.phase3.sportyshoes.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
