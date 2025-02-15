package com.example.demo.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Dao.ProductDao;
import com.example.demo.pojo.Product;
import com.example.demo.pojo.Users;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
          @Autowired
      private ProductDao productdao;

		public List<Product> displayinfo() {
			return productdao.findAll() ;
		}

		public Product saveproduct(Product obj) {
			Product product =  productdao.save(obj);
			return product;
		}

		public Product deleteproduct(Long id) {
			Optional<Product> product=productdao.findById(id);
		    productdao.deleteById(id);
			return product.get() ;
		}

		public Product updateinfo(Long id, Product obj) {
			
			Product product=productdao.save(obj);
			return product;
		}

		public Optional<Product> displaysingleinfo(Long id) {
			// TODO Auto-generated method stub
			return productdao.findById(id);
		}

		public Product uploadProductImage(Long productId, MultipartFile imageFile) throws IOException {

				Optional<Product> existingProductDetailsOptional =productdao.findById(productId);

				if (existingProductDetailsOptional.isEmpty()) {
					throw new RuntimeException("Provided product id is not present");
				}


				String filePath = buildImagePath(Objects.requireNonNull(imageFile.getOriginalFilename()), productId);
		    	Files.createDirectories(Path.of("src/main/resources/" + productId));
				
				Files.write(Path.of("src/main/resources/" + filePath), imageFile.getBytes());

				Product existingProductDetails = existingProductDetailsOptional.get();
				existingProductDetails.setProductImage(filePath);
				Product product=productdao.save(existingProductDetails);

				return product;
		}
		private String buildImagePath(String originalFileName, Long productId) {
			String[] fileNameParts = originalFileName.split("\\.");
			return   productId + "." + fileNameParts[1];
		}

		public ResponseEntity<InputStreamResource> downloadFile(Long productId) throws IOException {
			Optional<Product> existingProductDetailsOptional = productdao.findById(productId);

			if (existingProductDetailsOptional.isEmpty()) {
				throw new RuntimeException("Provided product id is not present");
			}

			Product existingProductDetails = existingProductDetailsOptional.get();

			InputStream inputStream = new FileInputStream("src/main/resources/" + existingProductDetails.getProductImage());
			InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			headers.setContentLength(Files.size(Paths.get("src/main/resources/" + existingProductDetails.getProductImage())));
			return new ResponseEntity<>(inputStreamResource, headers, HttpStatus.OK);
		
		}

		public List<Product> displayuserProduct(Long id) {
			
			return productdao.findAll().stream().filter(p->p.getUserId()==id).toList();
		}
        
		
		
          
}
