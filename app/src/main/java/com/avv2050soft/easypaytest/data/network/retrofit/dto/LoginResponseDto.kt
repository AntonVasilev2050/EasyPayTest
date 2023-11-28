package com.avv2050soft.easypaytest.data.network.retrofit.dto

import com.avv2050soft.easypaytest.domain.models.login.Error
import com.avv2050soft.easypaytest.domain.models.login.Response
import com.google.gson.annotations.SerializedName

data class LoginResponseDto (
    @SerializedName("error")
    val error: Error,
    @SerializedName("response")
    val response: Response,
    @SerializedName("success")
    val success: String
)