package com.example.demo.Controller;

import java.util.List;


import com.example.demo.DTO.PaymentDTO;
import com.example.demo.Service.PaymentService;
import com.example.demo.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    @Autowired
    private PaymentService paymentservice;

    // Fetch all payments
    @GetMapping("/display")
    public List<PaymentDTO> displaypayment() {
        return paymentservice.displayinfo().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Insert a new payment
    @PostMapping()
    public String insertproduct(@RequestBody PaymentDTO dto) {
        Payment payment = convertToEntity(dto);
        return paymentservice.savepayment(payment);
    }

    // Delete a payment
    @DeleteMapping("/{id}")
    public String deleteproduct(@PathVariable Long id) {
        return paymentservice.deletepayment(id);
    }

    // Update a payment
    @PutMapping("/{id}")
    public String updateproduct(@PathVariable Long id, @RequestBody PaymentDTO dto) {
        Payment payment = convertToEntity(dto);
        return paymentservice.updatepayment(id, payment);
    }


    private PaymentDTO convertToDTO(Payment payment) {
        return new PaymentDTO(
                payment.getPaymentid(),
                payment.getOrder(),
                payment.getTransaction_id(),
                payment.getPaymentGateway(),
                payment.getStatus(),
                payment.getAmount(),
                payment.getPaymentdate()
        );
    }

    private Payment convertToEntity(PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setPaymentid(dto.getPaymentid());
        payment.setOrder(dto.getOrder());
        payment.setTransaction_id(dto.getTransaction_id());
        payment.setPaymentGateway(dto.getPaymentGateway());
        payment.setStatus(dto.getStatus());
        payment.setAmount(dto.getAmount());
        payment.setPaymentdate(dto.getPaymentdate());
        return payment;
    }
	
	
	
}
