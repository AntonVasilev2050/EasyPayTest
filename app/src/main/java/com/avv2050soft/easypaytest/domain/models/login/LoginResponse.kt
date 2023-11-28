package com.avv2050soft.easypaytest.domain.models.login


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("error")
    val error: Error,
    @SerializedName("response")
    val response: Response,
    @SerializedName("success")
    val success: String
)