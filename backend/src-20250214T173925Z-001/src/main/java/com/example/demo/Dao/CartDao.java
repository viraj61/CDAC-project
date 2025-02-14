package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Cart;

public interface CartDao extends JpaRepository<Cart,Long> {

}
