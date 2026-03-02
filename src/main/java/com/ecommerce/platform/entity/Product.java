package com.ecommerce.platform.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
@NamedQuery(
	    name = "Product.findActiveByCategory",
	    query = "SELECT p FROM Product p WHERE p.category.name = :categoryName AND p.deleted = false"
	)
public class Product {
	//1.member variables
	//2.map member variables to column
	//3. one of the member variable should be Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name", length=150, nullable=false)
	private String name;
	
	@Column(name="price", nullable=false, precision = 10, scale=2)
	private BigDecimal price;
	
	@Column(name="stock_quantity")
	private Integer stockQuantity;
	
	//create relationship ManyToOne with Category
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id", nullable=false)
	private Category category;
	
	//soft delete field
	@Column(nullable = false)
	private boolean deleted = false;
	
	//create default constructor
	public Product() {
		this.id=0;
	}

	//create constructor with parameters
	public Product(String name, BigDecimal price, int stockQuality, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuality;
		this.category = category;
	}

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public void setStockQuality(int stockQuality) {
		this.stockQuantity = stockQuality;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stockQuality=" + stockQuantity
				+ ", category=" + category + "]";
	}
	
}
