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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phase3.sportyshoes.model.Category;
import com.phase3.sportyshoes.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/category/getAll")
	private List<Category> getAll(){
		return categoryService.getAll();
	}
	
	@GetMapping("/category/{id}")
	private Category getCategory (@PathVariable("id") int id) {
		return categoryService.getCategoryId(id);
	}
	
	@PostMapping("/category/add")
	private ResponseEntity saveCategory(@RequestBody Category category) {
		try {
			categoryService.createCategory(category);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity("New category created with id: "+category.getId(), HttpStatus.OK);
	}
	
	@DeleteMapping("/category/delete/{id}")
	private ResponseEntity<Category>delete(@PathVariable Integer id){
		try {
			categoryService.delete(id);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Deleted category with id: "+id, HttpStatus.OK);
	}

}
