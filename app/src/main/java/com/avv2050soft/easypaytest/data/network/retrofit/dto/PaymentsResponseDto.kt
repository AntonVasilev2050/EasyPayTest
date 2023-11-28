package com.avv2050soft.easypaytest.data.network.retrofit.dto

import com.avv2050soft.easypaytest.domain.models.payments.Response
import com.google.gson.annotations.SerializedName

data class PaymentsResponseDto(
    @SerializedName("response")
    val response: List<Response>,
    @SerializedName("success")
    val success: String
)