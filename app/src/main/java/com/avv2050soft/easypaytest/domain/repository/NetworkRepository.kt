package com.avv2050soft.easypaytest.domain.repository

import com.avv2050soft.easypaytest.domain.models.login.LoginResponse
import com.avv2050soft.easypaytest.domain.models.payments.PaymentsResponse

interface NetworkRepository {
    suspend fun login(): LoginResponse
    suspend fun getPayments(): PaymentsResponse
    suspend fun logout(): Boolean
}