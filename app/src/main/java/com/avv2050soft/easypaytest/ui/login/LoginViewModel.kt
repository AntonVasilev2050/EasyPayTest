package com.avv2050soft.easypaytest.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avv2050soft.easypaytest.domain.models.LoginRequest
import com.avv2050soft.easypaytest.domain.models.login.LoginResponse
import com.avv2050soft.easypaytest.domain.usecases.LoginUseCase
import com.avv2050soft.easypaytest.domain.usecases.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {
    private var loginResponse: LoginResponse? = null
    private val _loginResponseStateFlow = MutableStateFlow(loginResponse)
    val loginResponseStateFlow = _loginResponseStateFlow.asStateFlow()

    private val _errorLogin = Channel<String>()
    val errorLogin = _errorLogin.receiveAsFlow()

    suspend fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            kotlin.runCatching {
                loginResponse = loginUseCase.login(loginRequest)
            }.onSuccess {
                _loginResponseStateFlow.value = loginResponse
            }.onFailure {
                _errorLogin.send(it.message.toString())
                Log.d("data test", it.message.toString())
            }
        }
    }

    fun logout(): Boolean {
        var logoutResult = false
        viewModelScope.launch {
            logoutResult = logoutUseCase.logout()
            loginUseCase.login(LoginRequest("", ""))
        }
        return logoutResult
    }

    companion object {
        const val LOGIN_SUCCESS = "login success"
        const val LOGOUT_SUCCESS = "logout success"
        const val WRONG_LOGIN_OR_PASSWORD = "wrong login or password"
    }
}