package com.avv2050soft.easypaytest.domain.models


import com.google.gson.annotations.SerializedName

data class PaymentsResponse(
    @SerializedName("response")
    val response: List<Response>,
    @SerializedName("success")
    val success: String
)