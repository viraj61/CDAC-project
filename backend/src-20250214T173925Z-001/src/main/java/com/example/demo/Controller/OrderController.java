package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.OrderService;
import com.example.demo.Service.PaymentService;
import com.example.demo.pojo.Orders;
import com.example.demo.pojo.Payment;
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderservice;
	
	@GetMapping("/display")
	public List<Orders> displaypayment(){
		return orderservice.displayinfo();
	}
	
	@PostMapping()
	public Orders insertorder(@RequestBody Orders obj) {
	return orderservice.saveorder(obj); 
	}
	
	@DeleteMapping("/{id}")
	public String deleteorder(@PathVariable Long id) {
		return orderservice.deleteorder(id);
	}
	
	@PutMapping("/{id}")
	public String updateorder(@PathVariable Long id,@RequestBody Orders obj) {
		return orderservice.updateinfo(id,obj);
	}
	
	
	
	
}
