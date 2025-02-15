package com.example.demo.DTO;

import java.time.LocalDateTime;

import com.example.demo.pojo.Role;

public class UsersDTO {
	
	  private Long userId;
	  
	  private String name;
	  
	  private String email;
	  
	  private String password;
	  
	  private String phone;
	  
	  private int group_id;
	  
	  private Role role;
	  
	  private byte[] profile_picture;
	  
	  private LocalDateTime created_at;
	  
	  private LocalDateTime updated_at;

	public UsersDTO(Long userId, String name, String email, String password, String phone, int group_id, Role role,
			byte[] profile_picture, LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.group_id = group_id;
		this.role = role;
		this.profile_picture = profile_picture;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Long getUser_id() {
		return userId;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public byte[] getProfile_picture() {
		return profile_picture;
	}

	public void setProfile_picture(byte[] profile_picture) {
		this.profile_picture = profile_picture;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
}
