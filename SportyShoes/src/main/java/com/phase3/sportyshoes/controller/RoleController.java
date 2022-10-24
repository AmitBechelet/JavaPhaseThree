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

import com.phase3.sportyshoes.model.Role;
import com.phase3.sportyshoes.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@GetMapping("/role/getAll")
	private List<Role> getAll(){
		return roleService.getAll();
	}
	@PostMapping("/role/add")
	private ResponseEntity saveRole(@RequestBody Role role) {
		try {
			roleService.createRole(role);
		}catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity("New role created with id: "+role.getId(),HttpStatus.OK);
	}

	
	@DeleteMapping("/role/delete/{id}")
	private ResponseEntity<Role>delete(@PathVariable Integer id){
		try {
			roleService.delete(id);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Deleted role with id: "+id, HttpStatus.OK);
	}
}

