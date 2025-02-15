package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CartDTO;
import com.example.demo.Dao.CartDao;
import com.example.demo.pojo.Cart;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartService {
 
	@Autowired
	private CartDao cartdao;

	public List<Cart> displayinfo() {
		
		return cartdao.findAll();
	}

	public String savecart(Cart obj) {
		cartdao.save(obj);
		return "new cart added..";
	}

	public String deletecart(Long id) {
		cartdao.deleteById(id);
		return "cart has been removed";
	}

	public String updatecart(Long id, Cart obj) {
		cartdao.save(obj);
		return "cart updated...";
	}
	
	
	
	
	
	
	
	
	
}
