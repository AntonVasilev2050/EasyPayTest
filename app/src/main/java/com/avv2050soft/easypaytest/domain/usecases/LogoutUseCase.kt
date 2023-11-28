package com.avv2050soft.easypaytest.domain.usecases

import com.avv2050soft.easypaytest.domain.TokenStorage
import com.avv2050soft.easypaytest.domain.repository.NetworkRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val repository: NetworkRepository
) {
    suspend fun logout():Boolean{
        TokenStorage.accessToken = null
        return repository.logout()
    }
}