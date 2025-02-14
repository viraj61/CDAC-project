package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.DTO.CartDTO;
import com.example.demo.pojo.Cart;
import com.example.demo.pojo.Product;
import com.example.demo.pojo.Users;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @Autowired
    private CartService cartservice;

    @GetMapping("/display")
    public List<CartDTO> displayCart() {
        List<Cart> carts = cartservice.displayinfo();
        return carts.stream().map(cart -> new CartDTO(
                cart.getCart_id(),
                cart.getUser_id(),
                cart.getProduct_id(),
                cart.getTotal_price(),
                cart.getCreated_at(),
                cart.getUpdated_at()
        )).collect(Collectors.toList());
    }

    @PostMapping()
    public String insertCart(@RequestBody CartDTO obj) {
        Cart cart = new Cart();
        cart.setCart_id(obj.getCart_id());
        
        Users user = new Users();
        user.setUser_id(obj.getUser_id().getUser_id());
        cart.setUser_id(user);
        
        Product product = new Product();
        product.setProductId(obj.getProduct_id().getProductId());
        cart.setProduct_id(product);
        
        cart.setTotal_price(obj.getTotal_price());
        cart.setCreated_at(obj.getCreated_at());
        cart.setUpdated_at(obj.getUpdated_at());
        
        return cartservice.savecart(cart);
    }

    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable Long id) {
        return cartservice.deletecart(id);
    }

    @PutMapping("/{id}")
    public String updateCart(@PathVariable Long id, @RequestBody CartDTO obj) {
        Cart cart = new Cart();
        cart.setCart_id(obj.getCart_id());
        
        Users user = new Users();
        user.setUser_id(obj.getUser_id().getUser_id());
        cart.setUser_id(user);
        
        Product product = new Product();
        product.setProductId(obj.getProduct_id().getProductId());
        cart.setProduct_id(product);
        
        cart.setTotal_price(obj.getTotal_price());
        cart.setCreated_at(obj.getCreated_at());
        cart.setUpdated_at(obj.getUpdated_at());
        
        return cartservice.updatecart(id, cart);
    }	
}
