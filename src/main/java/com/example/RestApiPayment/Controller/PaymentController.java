package com.example.RestApiPayment.Controller;

import com.example.RestApiPayment.Entity.ExecutePayment;
import com.example.RestApiPayment.Entity.PaymentRequest;
import com.example.RestApiPayment.Service.PaymentService;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.APIContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public Payment createPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.create(paymentRequest);
    }

    @GetMapping("/execute")
    public Payment executePayment(@RequestBody ExecutePayment executePayment) {
        return paymentService.execute(executePayment);
    }
}
