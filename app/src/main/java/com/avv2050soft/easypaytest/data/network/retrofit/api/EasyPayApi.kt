package com.avv2050soft.easypaytest.data.network.retrofit.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

interface EasyPayApi {

    @POST("login")
    suspend fun login(): Boolean

//    @GET("payments")
//    suspend fun getPayments(): PaymentsResponseDto

    companion object{
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