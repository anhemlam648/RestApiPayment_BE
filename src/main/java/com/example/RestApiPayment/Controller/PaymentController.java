package com.example.RestApiPayment.Controller;

import com.example.RestApiPayment.Entity.ExecutePayment;
import com.example.RestApiPayment.Entity.PaymentRequest;
import com.example.RestApiPayment.Service.PaymentService;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.APIContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<String> createPayment(@RequestBody PaymentRequest paymentRequest) {
        String approvalUrl = paymentService.createPayment(paymentRequest);
        return ResponseEntity.ok(approvalUrl);
//        return paymentService.createPayment(paymentRequest);
    }

    @GetMapping("/execute")
    public Payment executePayment(@RequestBody ExecutePayment executePayment) {
        return paymentService.executePayment(executePayment);
    }
}
