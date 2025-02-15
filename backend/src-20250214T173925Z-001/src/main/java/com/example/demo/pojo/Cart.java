package com.example.demo.pojo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long cartId;

@OneToOne
@JoinColumn(name="user_id", nullable = false)
private Long userId;

@ManyToOne
@JoinColumn(name="Product_id",nullable=false)
private Long ProductId;

private double totalPrice;

private Date createdAt;

private Date updatedAt;

public Cart(Long cartId, Long userId, Long productId, double totalPrice, Date createdAt, Date updatedAt) {
	super();
	this.cartId = cartId;
	this.userId = userId;
	ProductId = productId;
	this.totalPrice = totalPrice;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
}

public Cart() {
	super();
}

public Long getCartId() {
	return cartId;
}

public void setCartId(Long cartId) {
	this.cartId = cartId;
}

public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

public Long getProductId() {
	return ProductId;
}

public void setProductId(Long productId) {
	ProductId = productId;
}

public double getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}




}
