package com.Tobeto.RentaCar.service.dto.request.Payment;

import com.google.gson.annotations.SerializedName;

public class CreatePaymentRequest {
    @SerializedName("items")
    Object[] items;

    public Object[] getItems() {
        return items;
    }
}
