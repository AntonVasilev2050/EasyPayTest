package com.avv2050soft.easypaytest.ui.payments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avv2050soft.easypaytest.domain.models.payments.PaymentsResponse
import com.avv2050soft.easypaytest.domain.usecases.GetPaymentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentsViewModel @Inject constructor(
    private val getPaymentsUseCase: GetPaymentsUseCase
) : ViewModel() {

    private var paymentsResponse: PaymentsResponse? = null
    private val _paymentsResponseStateFlow = MutableStateFlow(paymentsResponse)
    val paymentsResponseStateFlow = _paymentsResponseStateFlow.asStateFlow()

    suspend fun getPaymentsResponse(token: String?){
        viewModelScope.launch {
            kotlin.runCatching {
                paymentsResponse = getPaymentsUseCase.getPayments(token.toString())
            }.onSuccess {
                _paymentsResponseStateFlow.value = paymentsResponse
            }.onFailure {
                Log.d("data test", it.message.toString())
            }
        }
    }
}