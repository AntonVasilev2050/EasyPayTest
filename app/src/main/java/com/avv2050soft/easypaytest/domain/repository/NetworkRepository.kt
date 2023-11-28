package com.avv2050soft.easypaytest.domain.repository

import com.avv2050soft.easypaytest.domain.models.LoginRequest
import com.avv2050soft.easypaytest.domain.models.login.LoginResponse
import com.avv2050soft.easypaytest.domain.models.payments.PaymentsResponse

interface NetworkRepository {
    suspend fun login(loginRequest: LoginRequest): LoginResponse
    suspend fun getPayments(token: String): PaymentsResponse
    suspend fun logout(): Boolean
}