package com.ecommerce.platform.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
		name="category",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "name")
		
})
public class Category {
	//1. member variables
	//2. map each member variables to columns
	//3. one of the member variable should be Primary Key
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name", unique=true, nullable=false, length=100)
	private String name;
	
	@Column(name="description", length=500)
	private String desc;
	
	//create relationship one-to-many with Product
	@OneToMany(
            mappedBy = "category",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    private List<Product> products = new ArrayList<>();
	
	//create a default constructor
	public Category(){
		this.id=0;
		this.name=null;
		this.desc=null;
		this.products = new ArrayList<>();
	}
	//create a constructor with parameter
	public Category(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	
	//convenience method
	public void addProduct(Product product) {
		products.add(product);
		product.setCategory(this);
	}
	
	public void removeProduct(Product product) {
		products.remove(product);
		product.setCategory(this);
	}

	//getter & setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	//overriding method toString()
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}
	

}
