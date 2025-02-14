 package com.example.demo.pojo;

import java.time.LocalDate;
import java.util.Map;

import org.hibernate.annotations.Type;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "orders")

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

   @ManyToOne
   @JoinColumn(name = "user_id", nullable = false)
   private Users users; // Correct FK mapping
    
   
    
   
   @ManyToMany(mappedBy = "orders")
  private List<Product> product;
   
   
    private Long userId;
    
    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private Map<String, String> metadata;
   
   
   
  

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "payment_status")
    private Boolean paymentStatus;

	public Orders(Long orderId, Long userId, Map<String, String> metadata, double totalPrice, LocalDate createdAt,
			LocalDate updatedAt, Boolean paymentStatus) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.metadata = metadata;
		this.totalPrice = totalPrice;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.paymentStatus = paymentStatus;
	}

	public Orders() {
		super();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}



   
}
