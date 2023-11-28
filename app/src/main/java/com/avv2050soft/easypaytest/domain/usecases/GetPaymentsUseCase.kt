package com.avv2050soft.easypaytest.domain.usecases

import com.avv2050soft.easypaytest.domain.models.payments.PaymentsResponse
import com.avv2050soft.easypaytest.domain.repository.NetworkRepository
import javax.inject.Inject

class GetPaymentsUseCase @Inject constructor(
    private val repository: NetworkRepository
) {
    suspend fun getPayments(token: String): PaymentsResponse {
        return repository.getPayments(token)
    }
}