package com.avv2050soft.easypaytest.domain.usecases

import com.avv2050soft.easypaytest.domain.models.LoginRequest
import com.avv2050soft.easypaytest.domain.models.login.LoginResponse
import com.avv2050soft.easypaytest.domain.repository.NetworkRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: NetworkRepository
) {
    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        val loginResponse = repository.login(loginRequest)
        return loginResponse
    }
}