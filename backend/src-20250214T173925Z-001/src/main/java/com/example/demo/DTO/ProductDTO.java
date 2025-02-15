package com.example.demo.DTO;

import java.sql.Date;
import java.util.List;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Orders;
import com.example.demo.pojo.Users;

public class ProductDTO {
	private Long Product_id;
	
	private Users users;	
	
	private List<Orders> orders;
	
	private String Product_name;

	private byte[] Product_image;

	private String description;

	private Date created_at;

	private Date updated_at;

	private int Quantity;
	
	private Category catogry;

	public Long getProduct_id() {
		return Product_id;
	}

	public void setProduct_id(Long product_id) {
		Product_id = product_id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public String getProduct_name() {
		return Product_name;
	}

	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}

	public byte[] getProduct_image() {
		return Product_image;
	}

	public void setProduct_image(byte[] product_image) {
		Product_image = product_image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public Category getCatogry() {
		return catogry;
	}

	public void setCatogry(Category catogry) {
		this.catogry = catogry;
	}

	public ProductDTO(Long product_id, Users users, List<Orders> orders, String product_name, byte[] product_image,
			String description, Date created_at, Date updated_at, int quantity, Category catogry) {
		super();
		Product_id = product_id;
		this.users = users;
		this.orders = orders;
		Product_name = product_name;
		Product_image = product_image;
		this.description = description;
		this.created_at = created_at;
		this.updated_at = updated_at;
		Quantity = quantity;
		this.catogry = catogry;
	}

	public ProductDTO() {
		super();
	}
	
}
