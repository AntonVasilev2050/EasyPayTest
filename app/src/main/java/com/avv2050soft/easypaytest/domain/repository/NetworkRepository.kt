package com.avv2050soft.easypaytest.domain.repository

import com.avv2050soft.easypaytest.domain.models.PaymentsResponse

interface NetworkRepository {
    suspend fun login(): Boolean
    suspend fun getPayments(): PaymentsResponse
    suspend fun logout(): Boolean
}