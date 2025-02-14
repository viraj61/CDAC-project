package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Payment;

public interface PaymentDao extends JpaRepository<Payment,Long> {

}
