package com.avv2050soft.easypaytest.domain.models.payments


import com.google.gson.annotations.SerializedName

data class PaymentItem(
    @SerializedName("amount")
    val amount: String?,
    @SerializedName("created")
    val created: Int? = null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)