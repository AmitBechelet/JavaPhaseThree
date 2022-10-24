package com.phase3.sportyshoes.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3.sportyshoes.model.Role;
import com.phase3.sportyshoes.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> getAll(){
		List<Role> roles = new ArrayList<Role>();
		roleRepository.findAll().forEach(role ->roles.add(role));
		return roles;
	}
	
	public void createRole(Role role) {
		roleRepository.save(role);
	}
	
	public void delete(int id) {
		roleRepository.deleteById(id);
	}

}
