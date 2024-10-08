package com.example.RestApiPayment.Service;

import com.example.RestApiPayment.Entity.PaymentRequest;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private APIContext apiContext;

    //CreatePayment
    public String createPayment(PaymentRequest paymentRequest){
        try{
            Payer payer = new Payer();
            payer.setPaymentMethod(paymentRequest.getMethod());

            Amount amount = new Amount();
            amount.setTotal(String.format("%.2f",paymentRequest.getTotal())); // Convert string to real number
            amount.setCurrency(paymentRequest.getCurrency());

            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setDescription(paymentRequest.getDescription());

            List<Transaction> transactions = new ArrayList<>();
            transactions.add(transaction);

            Payment payment = new Payment();
            payment.setIntent(paymentRequest.getIntent());
            payment.setPayer(payer);
            payment.setTransactions(transactions);

            RedirectUrls redirectUrls = paymentRequest.getRedirectUrls();
            if (redirectUrls != null) {
                payment.setRedirectUrls(redirectUrls);
            } else {
                throw new RuntimeException("Redirect URLs must be provided.");
            }

            Payment createdPayment = payment.create(apiContext);

            for (Links link : createdPayment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return  link.getHref();
                }
            }
            throw new RuntimeException("Approval URL not found in PayPal response.");

            //return createdPayment;

        }catch (Exception ex){
            System.out.println("Error creating PayPal payment:" + ex.getMessage());
            throw new RuntimeException("Payment creation failed",ex);
        }
    }

    //ExcutePayment
        public Payment executePayment(String paymentId, String PayerId) throws PayPalRESTException {
            Payment payment = new Payment();
            payment.setId(paymentId);
            PaymentExecution paymentExecute = new PaymentExecution();
            paymentExecute.setPayerId(PayerId);
            return payment.execute(apiContext, paymentExecute);
    }
}
