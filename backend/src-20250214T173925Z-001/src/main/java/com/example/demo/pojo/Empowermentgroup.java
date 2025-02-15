package com.example.demo.pojo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empowermentgroup {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Emp_grp_id;

private String grp_name;

private Date created_at;

private Date updated_at;

private String description;


@ManyToOne
@JoinColumn(name = "user_id", nullable = false)
private Long userId;


public Empowermentgroup(Long emp_grp_id, String grp_name, Date created_at, Date updated_at, String description,
		Long userId) {
	super();
	Emp_grp_id = emp_grp_id;
	this.grp_name = grp_name;
	this.created_at = created_at;
	this.updated_at = updated_at;
	this.description = description;
	this.userId = userId;
}


public Empowermentgroup() {
	super();
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


public Long getUserId() {
	return userId;
}


public void setUserId(Long userId) {
	this.userId = userId;
}





}
