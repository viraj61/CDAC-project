package com.example.demo.pojo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Paymentid;

@OneToOne
@JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
private Orders orderId;



private int transactionId;

private String paymentGateway;

private String Status;

private double Amount;

private Date Paymentdate;

public Payment(Long paymentid, int transactionId, String paymentGateway, String status, double amount,
		Date paymentdate) {
	super();
	Paymentid = paymentid;
	this.transactionId = transactionId;
	this.paymentGateway = paymentGateway;
	Status = status;
	Amount = amount;
	Paymentdate = paymentdate;
}

public Payment() {
	super();
}

public Long getPaymentid() {
	return Paymentid;
}

public void setPaymentid(Long paymentid) {
	Paymentid = paymentid;
}

public int getTransaction_id() {
	return transactionId;
}

public void setTransaction_id(int transaction_id) {
	this.transactionId = transaction_id;
}

public String getPaymentGateway() {
	return paymentGateway;
}

public void setPaymentGateway(String paymentGateway) {
	this.paymentGateway = paymentGateway;
}

public String getStatus() {
	return Status;
}

public void setStatus(String status) {
	Status = status;
}

public double getAmount() {
	return Amount;
}

public void setAmount(double amount) {
	Amount = amount;
}

public Date getPaymentdate() {
	return Paymentdate;
}

public void setPaymentdate(Date paymentdate) {
	Paymentdate = paymentdate;
}



}
