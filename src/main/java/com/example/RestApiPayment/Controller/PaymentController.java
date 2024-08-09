package com.example.RestApiPayment.Controller;

import com.example.RestApiPayment.Entity.PaymentRequest;
import com.example.RestApiPayment.Service.PaymentService;
import com.paypal.api.payments.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "http://localhost:3030")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<String> createPayment(@RequestBody PaymentRequest paymentRequest) {
        String approvalUrl = paymentService.createPayment(paymentRequest);
        return ResponseEntity.ok(approvalUrl);
    }

    @GetMapping("/execute")
    public ResponseEntity<Payment> executePayment( @RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String PayerID) {
        try {
            Payment payment = paymentService.executePayment(paymentId, PayerID );
            System.out.println("Success" + payment);
            return ResponseEntity.ok(payment);
        } catch (Exception ex) {
            System.out.println("Error executing PayPal payment: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
