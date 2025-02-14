package com.example.demo.DTO;

import java.sql.Date;

import com.example.demo.pojo.Orders;

public class PaymentDTO {
	private Long Paymentid;
	
	private Orders order;
	
	private int transaction_id;

	private String paymentGateway;

	private String Status;

	private double Amount;

	private Date Paymentdate;
	
	public Long getPaymentid() {
		return Paymentid;
	}

	public void setPaymentid(Long paymentid) {
		Paymentid = paymentid;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
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

	public PaymentDTO(Long paymentid, Orders order, int transaction_id, String paymentGateway, String status,
			double amount, Date paymentdate) {
		super();
		Paymentid = paymentid;
		this.order = order;
		this.transaction_id = transaction_id;
		this.paymentGateway = paymentGateway;
		Status = status;
		Amount = amount;
		Paymentdate = paymentdate;
	}

	public PaymentDTO() {
		super();
	}

	


	
	
	
	
}
