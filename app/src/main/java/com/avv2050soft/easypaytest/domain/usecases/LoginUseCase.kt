package com.avv2050soft.easypaytest.domain.usecases

import com.avv2050soft.easypaytest.domain.TokenStorage
import com.avv2050soft.easypaytest.domain.repository.NetworkRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: NetworkRepository
) {
    suspend fun login(): Boolean {
        val loginResponse = repository.login()
        return if (loginResponse.success == "true") {
            TokenStorage.accessToken = loginResponse.response.token
            true
        } else {
            TokenStorage.accessToken = null
            false
        }
    }
}