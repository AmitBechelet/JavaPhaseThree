package com.phase3.sportyshoes.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3.sportyshoes.model.Category;
import com.phase3.sportyshoes.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAll(){
		List<Category> categories = new ArrayList<Category>();
		categoryRepository.findAll().forEach(category ->categories.add(category));
		return categories;
	}
	
	public Category getCategoryId(int id) {
		return categoryRepository.findById(id).get();
	}
	
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public void delete(int id) {
		categoryRepository.deleteById(id);
	}

}
