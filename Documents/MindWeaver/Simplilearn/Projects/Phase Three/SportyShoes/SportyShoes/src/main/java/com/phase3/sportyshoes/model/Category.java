package com.phase3.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	private int id;
	private String name;

}
