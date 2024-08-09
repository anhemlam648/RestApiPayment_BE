package com.example.RestApiPayment.Config;

import com.paypal.base.rest.APIContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigPaypal {

    @Bean
    public APIContext apiContext(){
        String clientSecret = "EGxjpSZy6LpEap7p6XNL-UTPp9qGk40KoRRtMBkgVyIhjAwKAgges467CfQDvbUObBQWjyyWC2CrqA7M";
        String clientId = "AXOW5Qey24a7SsrpZai_F40P172AI6FnBLYrAlekiYegihzKdEzevw2ZbZhQfMbsJbuSPr0_9XSM0PUm";
        String mode = "sandbox";

        return new APIContext(clientId, clientSecret, mode );
    }

}
