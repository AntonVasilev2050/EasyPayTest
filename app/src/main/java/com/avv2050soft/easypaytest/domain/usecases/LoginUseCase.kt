package com.avv2050soft.easypaytest.domain.usecases

import com.avv2050soft.easypaytest.domain.repository.NetworkRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: NetworkRepository
) {
    suspend fun login(): Boolean{
        return repository.login()
    }
}