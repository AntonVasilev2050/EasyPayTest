package com.avv2050soft.easypaytest.data.network.retrofit.api

import com.avv2050soft.easypaytest.data.network.retrofit.dto.LoginResponseDto
import com.avv2050soft.easypaytest.data.network.retrofit.dto.PaymentsResponseDto
import com.avv2050soft.easypaytest.domain.models.LoginRequest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface EasyPayApi {

    @Headers("app-key: 12345", "v: 1")
    @POST("login")
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): LoginResponseDto

    @Headers("app-key: 12345", "v: 1")
    @GET("payments")
    suspend fun getPayments(
        @Header("token") token: String
    ): PaymentsResponseDto

    companion object {
        private const val BASE_URL = "https://easypay.world/api-test/"

        fun create(): EasyPayApi {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EasyPayApi::class.java)
        }
    }
}