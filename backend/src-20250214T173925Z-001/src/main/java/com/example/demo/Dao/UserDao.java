package com.example.demo.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Users;

public interface UserDao extends JpaRepository<Users,Long> {
	
    Optional<Users> findByEmail(String email);

	Optional<Users> findByPhone(String phoneNumber);


}


