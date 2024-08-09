package com.example.RestApiPayment.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExecutePaymentRequest {
    public String paymentId;
    public String payerId;
}
