package com.phase3.sportyshoes.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phase3.sportyshoes.model.Product;
import com.phase3.sportyshoes.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> products.add(product));
		return products;
	}
	
	public Product getProductById(int id) {
		return productRepository.findById(id).get();
	}
	
	public void saveOrUpdate(Product product) {
		productRepository.save(product);
	}
	
	public void delete(int id) {
		productRepository.deleteById(id);
	}

}
