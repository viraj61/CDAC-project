package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Orders;

public interface OrderDao extends JpaRepository<Orders,Long> {

}
