package com.phase3.sportyshoes.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phase3.sportyshoes.model.User;
import com.phase3.sportyshoes.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/users/getAll")
	private List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	private ResponseEntity<User> get(@PathVariable Integer id) {
		try {
			User user = userService.getUserById(id);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/users/add")
	private ResponseEntity saveUser(@RequestBody User user) {
		try {
			userService.saveOrUpdate(user);
		}	catch(Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Neew user added with id: "+user.getId(), HttpStatus.CREATED);
	}

}


