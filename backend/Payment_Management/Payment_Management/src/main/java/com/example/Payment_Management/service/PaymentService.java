package com.example.Payment_Management.service;

import com.example.Payment_Management.Model.Payment;
import com.example.Payment_Management.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repo;

    public Payment addPayment(Payment payment) {
        return repo.save(payment);
    }

    public List<Payment> getAllPayments() {
        return repo.findAll();
    }

    public Payment getPaymentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        Payment payment = repo.findById(id).orElse(null);
        if (payment != null) {
            payment.setAmount(updatedPayment.getAmount());
            payment.setPaymentDate(updatedPayment.getPaymentDate());
            payment.setStatus(updatedPayment.getStatus());
            payment.setPaymentMethod(updatedPayment.getPaymentMethod());
            payment.setPayerName(updatedPayment.getPayerName());
            return repo.save(payment);
        }
        return null;
    }

    public void deletePayment(Long id) {
        repo.deleteById(id);
    }
}
