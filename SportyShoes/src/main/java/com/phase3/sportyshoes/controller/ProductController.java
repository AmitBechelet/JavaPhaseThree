package com.phase3.sportyshoes.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phase3.sportyshoes.model.Product;
import com.phase3.sportyshoes.model.User;
import com.phase3.sportyshoes.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product/getAll")
	private List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	private Product getProduct(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}
	
	@DeleteMapping("/product/delete/{id}")
	private ResponseEntity<Product>delete(@PathVariable Integer id) {
		try {
			productService.delete(id);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Deleted product with id: " +id, HttpStatus.OK);
	}
	
	@PostMapping("/product")
	private ResponseEntity saveOrUpdate(@RequestBody Product product) {
		try {
			productService.saveOrUpdate(product);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity("New product created with id: "+product.getId(), HttpStatus.CREATED);
	}
	
	@PutMapping("/product/{id}")
	private ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Integer id){
		try {
			Product xproduct = productService.getProductById(id);
			productService.saveOrUpdate(xproduct);
			return new ResponseEntity<Product>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
}
