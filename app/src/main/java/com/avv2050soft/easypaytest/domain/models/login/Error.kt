package com.avv2050soft.easypaytest.domain.models.login


import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("error_code")
    val errorCode: Int,
    @SerializedName("error_msg")
    val errorMsg: String
)