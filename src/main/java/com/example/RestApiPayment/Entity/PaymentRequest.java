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
    public Double total;
    public String currency;
    public String method;
    public String intent;
    public String description;
    private RedirectUrls redirectUrls;
}
