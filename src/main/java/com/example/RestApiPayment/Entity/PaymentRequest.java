package com.example.RestApiPayment.Entity;

import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private Double total;
    private String currency;
    private String method;
    private String intent;
    private String description;
    private RedirectUrls redirectUrls;
}
