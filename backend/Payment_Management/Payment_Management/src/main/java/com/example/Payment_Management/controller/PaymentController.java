package com.example.Payment_Management.controller;

import com.example.Payment_Management.Model.Payment;
import com.example.Payment_Management.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService service;
    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody Payment payment) {
        try {
            Payment savedPayment = service.addPayment(payment);
            return ResponseEntity.ok(savedPayment);
        } catch (Exception e) {
            e.printStackTrace(); // prints the full stack trace to console
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving payment: " + e.getMessage());
        }
    }
    @GetMapping
    public List<Payment>getPayments(){
        return  service.getAllPayments();
    }
    @GetMapping("/{id}")
    public Payment
    getPaymentById(@PathVariable Long id){
        return service.getPaymentById(id);
    }
    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id,@RequestBody Payment updatedPayment){
        return service.updatePayment(id,updatedPayment);
    }
    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id){
        service.deletePayment(id);
    }
    @GetMapping("/test")
    public String test() {
        return "API is working";
    }
}
