package com.avv2050soft.easypaytest.domain.models.payments


import com.google.gson.annotations.SerializedName

data class PaymentsResponse(
    @SerializedName("response")
    val paymentItems: List<PaymentItem>,
    @SerializedName("success")
    val success: String
)