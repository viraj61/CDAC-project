package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.OrderDao;
import com.example.demo.Dao.PaymentDao;
import com.example.demo.pojo.Orders;
import com.example.demo.pojo.Payment;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {
    @Autowired
	private	OrderDao orderdao; 

	public List<Orders> displayinfo() {
		return orderdao.findAll() ;
	}

	

	public Orders saveOrder(Orders obj) {
		if (obj == null || obj.getTotalPrice() <= 0) {
			throw new InvalidOrderException();
		} else {
			return orderdao.save(obj);
		}
	}
	

	public String deleteorder(Long id) {
		orderdao.deleteById(id);
		return "Record deleted...";
	}

	public String updateinfo(Long id, Orders obj) {
		orderdao.save(obj);
		return "Record updated...";
	}
	
	
}
