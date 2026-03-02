package com.ecommerce.platform.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	//1.member variables
	//2.map each member variables to columns
	//3.one of the member variables should be Primary Key

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username", length=50, unique=true, nullable=false)
	private String username;
	
	@Column(name="password", length=100, nullable=false)
	private String password;
	
	@Column(name="email", length=120, unique=true, nullable=false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	
	@OneToMany(mappedBy="users", 
			cascade= {CascadeType.PERSIST, CascadeType.MERGE},
			fetch=FetchType.LAZY)
	private List<Orders> orders = new ArrayList<>();
	
	public Users() {
		this.id = 0;
	}

	public Users(String username, String password, String email, Role role, List<Orders> orders) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ role + "]";
	}
	

}
