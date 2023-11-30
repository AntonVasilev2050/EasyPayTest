package com.avv2050soft.easypaytest.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.avv2050soft.easypaytest.R
import com.avv2050soft.easypaytest.databinding.FragmentLoginBinding
import com.avv2050soft.easypaytest.domain.TokenStorage
import com.avv2050soft.easypaytest.domain.models.LoginRequest
import com.avv2050soft.easypaytest.ui.utils.launchAndCollectIn
import com.avv2050soft.easypaytest.ui.utils.toastString
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (TokenStorage.accessToken.isNullOrEmpty()) {
            setLoginButtonVisible(true)
            waitForLogin()
        } else {
            setLoginButtonVisible(false)
            waitForLogout()
        }

        loginViewModel.errorLogin.launchAndCollectIn(viewLifecycleOwner) {
            toastString(it)
        }
    }

    private fun waitForLogout() {
        binding.buttonLogout.setOnClickListener {
            loginViewModel.logout()
            toastString(LoginViewModel.LOGOUT_SUCCESS)
            setLoginButtonVisible(true)
        }
    }

    private fun waitForLogin() {
        binding.buttonLogin.setOnClickListener {
            loginViewModel.loginResponseStateFlow.launchAndCollectIn(viewLifecycleOwner) {
                val loginRequest = LoginRequest(
                    binding.textInputLogin.text.toString(),
                    binding.textInputPassword.text.toString()
                )
                loginViewModel.login(loginRequest)

                it?.let { loginResponse ->
                    if (loginResponse.success == "true") {
                        TokenStorage.accessToken = loginResponse.response?.token
                        toastString(LoginViewModel.LOGIN_SUCCESS)
                        setLoginButtonVisible(false)
                    } else {
                        TokenStorage.accessToken = null
                        toastString(LoginViewModel.WRONG_LOGIN_OR_PASSWORD)
                    }
                }
            }
        }
    }

    private fun setLoginButtonVisible(visible: Boolean) {
        if (visible) {
            binding.buttonLogin.visibility = View.VISIBLE
            binding.buttonLogout.visibility = View.GONE
            binding.textInputPassword.setText("")
            binding.textInputLogin.setText("")
        } else {
            binding.buttonLogin.visibility = View.GONE
            binding.buttonLogout.visibility = View.VISIBLE
        }
    }
}