package com.avv2050soft.easypaytest.data.network.retrofit.repository

import com.avv2050soft.easypaytest.domain.models.PaymentsResponse
import com.avv2050soft.easypaytest.domain.repository.NetworkRepository

class NetworkRepositoryImpl: NetworkRepository {
    override suspend fun login(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getPayments(): PaymentsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun logout(): Boolean {
        TODO("Not yet implemented")
    }
}