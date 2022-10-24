package com.phase3.sportyshoes.service;

import java.util.*;

import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3.sportyshoes.model.Role;
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
	
//	public User getUserByName(String username) {
//		return userRepository.findByName(username).get();
//	}
	
//	public User getUserByEmail(String email) {
//		return userRepository.findByEmail(email).get();
//}

	public void saveOrUpdate(User user) {
		userRepository.save(user);		
	}

	
//	public void saveUserRole() {
//		Role role = new Role(role);
//		User user = new User (user);
//		user.setRole(role);
//	}
}
