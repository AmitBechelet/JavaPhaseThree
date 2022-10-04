package com.phase3.sportyshoes.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3.sportyshoes.model.User;
import com.phase3.sportyshoes.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(user ->users.add(user));
		return users;		
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}
	
	public User getUserByName(String name) {
		return userRepository.findByName(name).get();
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email).get();
}

	public void saveOrUpdate(User user) {
		userRepository.save(user);		
	}
}
