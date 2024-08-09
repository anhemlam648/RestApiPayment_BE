package com.example.RestApiPayment.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RedirectUrls {
    private String returnUrl;
    private String cancelUrl;
}
