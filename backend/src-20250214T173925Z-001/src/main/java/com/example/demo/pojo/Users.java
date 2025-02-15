package com.example.demo.pojo;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	    @Column(name = "user_id") 
	    private Long userId;

	    @Column(name = "name", nullable = false)
	    private String name;

	    @Column(name = "email", nullable = false, unique = true) 
	    private String email;

	    @Column(name = "password", nullable = false) 
	    private String password;
	    
	    private String phone;

	    @Column(name = "group_id")
	    private int groupId;

	    @Enumerated(EnumType.STRING) 
	    @Column(name = "role", nullable = false)
	    private Role role;


        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<EmpowermentGroup> empowermentGroups;





        @CreationTimestamp
	    @Column(name = "created_at", nullable = false, updatable = false)
	    private LocalDateTime created_at;
        
        @UpdateTimestamp
	    @Column(name = "updated_at")
	    private LocalDateTime updated_at;
        
        public Users() {
        	
        }

		public Users(Long userId, String name, String email, String password, String phone, int groupId, Role role,
				LocalDateTime created_at, LocalDateTime updated_at) {
			super();
			this.userId = userId;
			this.name = name;
			this.email = email;
			this.password = password;
			this.phone = phone;
			this.groupId = groupId;
			this.role = role;
			this.created_at = created_at;
			this.updated_at = updated_at;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
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

		public int getGroupId() {
			return groupId;
		}

		public void setGroupId(int groupId) {
			this.groupId = groupId;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
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
