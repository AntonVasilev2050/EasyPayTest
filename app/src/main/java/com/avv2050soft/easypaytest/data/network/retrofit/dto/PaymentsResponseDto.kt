package com.avv2050soft.easypaytest.data.network.retrofit.dto

import com.avv2050soft.easypaytest.domain.models.payments.PaymentItem
import com.google.gson.annotations.SerializedName

data class PaymentsResponseDto(
    @SerializedName("response")
    val paymentItems: List<PaymentItem>,
    @SerializedName("success")
    val success: String
)