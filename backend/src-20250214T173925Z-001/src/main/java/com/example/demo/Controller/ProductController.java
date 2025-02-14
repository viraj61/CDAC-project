package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.ProductService;
import com.example.demo.pojo.Product;
import com.example.demo.pojo.Users;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Service.ProductService;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.pojo.Product;
import com.example.demo.pojo.Users;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productservice;

    // Display all products using DTO
    @GetMapping("/display")
    public List<ProductDTO> displayProduct() {
        List<Product> products = productservice.displayinfo();

        return products.stream().map(product -> new ProductDTO(
                product.getProductId(),
                product.getPrice(),
                product.getUserId().getUser_id(), // Extract userId from Users entity
                product.getProductName(),
                product.getProductImage(),
                product.getDescription(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.getQuantity(),
                product.getCategory()
        )).collect(Collectors.toList());
    }

    // Display a single product using DTO
    @GetMapping("/{id}")
    public Optional<ProductDTO> displaySingleProduct(@PathVariable Long id) {
        Optional<Product> product = productservice.displaysingleinfo(id);

        return product.map(p -> new ProductDTO(
                p.getProductId(),
                p.getPrice(),
                p.getUserId().getUser_id(),
                p.getProductName(),
                p.getProductImage(),
                p.getDescription(),
                p.getCreatedAt(),
                p.getUpdatedAt(),
                p.getQuantity(),
                p.getCategory()
        ));
    }

    @GetMapping("/{id}/product")
    public List<ProductDTO> displaySingleUserBaseProduct(@PathVariable Long id) {
        List<Product> products = productservice.displayuserProduct(id);

        return products.stream().map(p -> new ProductDTO(
                p.getProductId(),
                p.getPrice(),
                p.getUserId().getUser_id(),
                p.getProductName(),
                p.getProductImage(),
                p.getDescription(),
                p.getCreatedAt(),
                p.getUpdatedAt(),
                p.getQuantity(),
                p.getCategory()
        )).collect(Collectors.toList());
    }

   
    @PostMapping()
    public Product insertProduct(@RequestBody ProductDTO obj) {
        Product product = new Product();
        product.setProductId(obj.getProductId());
        product.setPrice(obj.getPrice());

        Users user = new Users();
        user.setUser_id(obj.getUserId());
        product.setUserId(user);  // Assign user object

        product.setProductName(obj.getProductName());
        product.setProductImage(obj.getProductImage());
        product.setDescription(obj.getDescription());
        product.setCreatedAt(obj.getCreatedAt());
        product.setUpdatedAt(obj.getUpdatedAt());
        product.setQuantity(obj.getQuantity());
        product.setCategory(obj.getCategory());

        return productservice.saveproduct(product);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        return productservice.deleteproduct(id);
    }

   
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDTO obj) {
        Product product = new Product();
        product.setProductId(obj.getProductId());
        product.setPrice(obj.getPrice());

        Users user = new Users();
        user.setUser_id(obj.getUserId());
        product.setUserId(user);  // Assign user object

        product.setProductName(obj.getProductName());
        product.setProductImage(obj.getProductImage());
        product.setDescription(obj.getDescription());
        product.setCreatedAt(obj.getCreatedAt());
        product.setUpdatedAt(obj.getUpdatedAt());
        product.setQuantity(obj.getQuantity());
        product.setCategory(obj.getCategory());

        return productservice.updateinfo(id, product);
    }

    // Upload product image
    @PutMapping("/{productId}/image")
    public Product updateProductImage(@PathVariable Long productId, @RequestPart MultipartFile imageFile) throws Exception {
        return productservice.uploadProductImage(productId, imageFile);
    }

    // Download product image
    @GetMapping("/{productId}/image")
    public ResponseEntity<InputStreamResource> downloadImage(@PathVariable Long productId) throws IOException {
        return productservice.downloadFile(productId);
    }
}
	
	
	

