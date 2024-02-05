package com.Tobeto.RentaCar.service.dto.response.Payment;

public class GetPaymentResponse {
    private String clientSecret;
    public GetPaymentResponse(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
