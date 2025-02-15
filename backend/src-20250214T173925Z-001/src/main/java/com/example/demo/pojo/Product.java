package com.example.demo.pojo;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long ProductId;
	
@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "user_id", nullable = false)
private Users userId;	

private double price;
	


@ManyToMany(cascade = CascadeType.ALL)
@JsonIgnore
@JoinTable(name="order_product_fk",
joinColumns = @JoinColumn(name="Product_id"),
inverseJoinColumns = @JoinColumn(name="order_id"))
private List<Orders> orders;

private String ProductName;

private String ProductImage;

private String description;

private LocalDate createdAt;

private LocalDate updatedAt;

private int Quantity;

@Enumerated(EnumType.STRING) 
@Column(name = "category", nullable = false)
private Category category;

public Product(Long productId, double price, Long userId, String productName, String productImage, String description,
		LocalDate createdAt, LocalDate updatedAt, int quantity, Category category) {
	super();
	ProductId = productId;
	this.price = price;
	this.userId = userId;
	ProductName = productName;
	ProductImage = productImage;
	this.description = description;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	Quantity = quantity;
	this.category = category;
}

public Product() {
	super();
}

public Long getProductId() {
	return ProductId;
}

public void setProductId(Long productId) {
	ProductId = productId;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

public String getProductName() {
	return ProductName;
}

public void setProductName(String productName) {
	ProductName = productName;
}

public String getProductImage() {
	return ProductImage;
}

public void setProductImage(String productImage) {
	ProductImage = productImage;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public LocalDate getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(LocalDate createdAt) {
	this.createdAt = createdAt;
}

public LocalDate getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(LocalDate updatedAt) {
	this.updatedAt = updatedAt;
}

public int getQuantity() {
	return Quantity;
}

public void setQuantity(int quantity) {
	Quantity = quantity;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}









}