package com.example.demo.DTO;

import java.sql.Date;

import com.example.demo.pojo.Product;
import com.example.demo.pojo.Users;

public class CartDTO {
	private Long cart_id;
	private Users user_id;
	private Product Product_id;
	private double total_price;
	private Date created_at;
	private Date updated_at;
	public Long getCart_id() {
		return cart_id;
	}
	public void setCart_id(Long cart_id) {
		this.cart_id = cart_id;
	}
	public Users getUser_id() {
		return user_id;
	}
	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}
	public Product getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(Product product_id) {
		Product_id = product_id;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public CartDTO(Long cart_id, Users user_id, Product product_id, double total_price, Date created_at,
			Date updated_at) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		Product_id = product_id;
		this.total_price = total_price;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public CartDTO() {
		super();
	}
	
	
}
