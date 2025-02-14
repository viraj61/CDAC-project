package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.pojo.Product;
import com.example.demo.pojo.Users;

public class OrdersDTO {

	  private Long order_id;
	  
	  private Users users;
	  
	  private List<Product> product;
	
	  private double total_price;
	  
	  private LocalDate created_at;
	  
	  private LocalDate updated_at;
	  
	  public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public LocalDate getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}

	public LocalDate getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDate updated_at) {
		this.updated_at = updated_at;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getPayment_gateway() {
		return payment_gateway;
	}

	public void setPayment_gateway(String payment_gateway) {
		this.payment_gateway = payment_gateway;
	}

	private String payment_status;
	  
	  private String payment_gateway;

	public OrdersDTO(Long order_id, Users users, List<Product> product, double total_price, LocalDate created_at,
			LocalDate updated_at, String payment_status, String payment_gateway) {
		super();
		this.order_id = order_id;
		this.users = users;
		this.product = product;
		this.total_price = total_price;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.payment_status = payment_status;
		this.payment_gateway = payment_gateway;
	}

	public OrdersDTO() {
		super();
	}
	  
	  
	  
}
