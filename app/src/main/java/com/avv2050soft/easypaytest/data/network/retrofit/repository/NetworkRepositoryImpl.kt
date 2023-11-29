package com.avv2050soft.easypaytest.data.network.retrofit.repository

import com.avv2050soft.easypaytest.data.network.retrofit.api.EasyPayApi
import com.avv2050soft.easypaytest.data.network.retrofit.mappers.RetrofitMapper
import com.avv2050soft.easypaytest.domain.models.LoginRequest
import com.avv2050soft.easypaytest.domain.models.login.LoginResponse
import com.avv2050soft.easypaytest.domain.models.payments.PaymentsResponse
import com.avv2050soft.easypaytest.domain.repository.NetworkRepository
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val mapper: RetrofitMapper
): NetworkRepository {
    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return  mapper.mapLoginResponseDtoToLoginResponse(EasyPayApi.create().login(loginRequest))
    }

    override suspend fun getPayments(token: String): PaymentsResponse {
        return mapper.mapPaymentsResponseDtoToPaymentsResponse(EasyPayApi.create().getPayments(token))
    }

    override suspend fun logout(): LoginResponse {
        val loginRequest = LoginRequest("", "")
        return  mapper.mapLoginResponseDtoToLoginResponse(EasyPayApi.create().login(loginRequest))
    }
}