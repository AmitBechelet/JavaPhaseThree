package com.phase3.sportyshoes.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer role_id;
	@Column(nullable = false)
	private String name;
	
	public Role() {
	}
	
	public Role(String name, int role_id) {
		super();
		this.role_id = role_id;
		this.name = name;
	}

	public Integer getId() {
		return role_id;
	}

	public void setId(Integer id) {
		this.role_id = id;
	}
			
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

//
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
//	private List<User> user;
//	
////	@OneToMany(targetEntity=User.class, mappedBy="roles",fetch=FetchType.EAGER)
////	private List<User>users;
//	
//	
//	public List<User>getUsers(){
//		return user;
//	}
//	
//	public void setUsers(List<User> users) {
//		this.user = users;
//	}
//
//
//
////	public Role(Integer id, String name) {
////		this.role_id = id;
////		this.name = name;
//	}
//
//
//	}
//
//
//
////--------------------------------------------------
////	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user_id")
////	@JoinColumn(name = "user_id")
////	private User user;
//}
