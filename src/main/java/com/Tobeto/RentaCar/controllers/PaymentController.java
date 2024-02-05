package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.dto.request.Payment.CreatePaymentRequest;
import com.Tobeto.RentaCar.service.dto.response.Payment.GetPaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/payments")
@CrossOrigin
public class PaymentController {

    @PostMapping("/create-payment-intent")
    public GetPaymentResponse createPaymentIntent(@RequestBody CreatePaymentRequest createPaymentRequest) throws StripeException {

        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(15 * 100L)
                        .setCurrency("usd")
                        // In the latest version of the API, specifying the automatic_payment_methods parameter is optional because Stripe enables its functionality by default.
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams.AutomaticPaymentMethods
                                        .builder()
                                        .setEnabled(true)
                                        .build()
                        )
                        .build();

        // Create a PaymentIntent with the order amount and currency
        PaymentIntent paymentIntent = PaymentIntent.create(params);

        return new GetPaymentResponse(paymentIntent.getClientSecret());

    }
}
