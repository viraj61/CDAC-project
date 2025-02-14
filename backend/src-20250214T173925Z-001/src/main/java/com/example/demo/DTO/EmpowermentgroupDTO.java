package com.example.demo.DTO;

import java.sql.Date;

import com.example.demo.pojo.Users;

public class EmpowermentgroupDTO {
	private Long Emp_grp_id;

	private String grp_name;

	public EmpowermentgroupDTO() {
		super();
	}

	public EmpowermentgroupDTO(Long emp_grp_id, String grp_name, Date created_at, Date updated_at, String description,
			Users users) {
		super();
		Emp_grp_id = emp_grp_id;
		this.grp_name = grp_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.description = description;
		this.users = users;
	}

	public Long getEmp_grp_id() {
		return Emp_grp_id;
	}

	public void setEmp_grp_id(Long emp_grp_id) {
		Emp_grp_id = emp_grp_id;
	}

	public String getGrp_name() {
		return grp_name;
	}

	public void setGrp_name(String grp_name) {
		this.grp_name = grp_name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	private Date created_at;

	private Date updated_at;

	private String description;
	
	private Users users;
}
