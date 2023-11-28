package com.avv2050soft.easypaytest.domain.models.login


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("token")
    val token: String
)