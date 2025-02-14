package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.PaymentDao;
import com.example.demo.pojo.Payment;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class PaymentService {
	
@Autowired	
private	PaymentDao paymentdao; 

	public List<Payment> displayinfo() {
		
		return paymentdao.findAll() ;
	}

	public String savepayment(Payment obj) {
	       paymentdao.save(obj);
		return "payment record added";
	}

	public String deletepayment(Long id) {
		paymentdao.deleteById(id);
		return "Record deleted...";
	}

	public String updatepayment(Long id, Payment obj) {
		paymentdao.save(obj);
		return "Record updated...";
	}
	
	
	
	

}
