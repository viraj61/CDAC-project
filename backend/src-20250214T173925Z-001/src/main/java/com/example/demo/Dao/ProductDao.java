package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Product;
import java.util.List;


public interface ProductDao extends JpaRepository<Product, Long> {
	

}
