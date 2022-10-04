package com.phase3.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phase3.sportyshoes.model.Product;
import com.phase3.sportyshoes.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	private List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	private Product getProduct(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}
	
	@DeleteMapping("/product/{id}")
	private void deletProduct(@PathVariable("id") int id) {
		productService.delete(id);
	}
	
	@PostMapping("/product")
	private int saveProduct(@RequestBody Product product) {
		productService.saveOrUpdate(product);
		return product.getId();
	}
}
