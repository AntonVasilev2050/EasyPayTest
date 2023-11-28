package com.avv2050soft.easypaytest.data.network.retrofit.mappers

import com.avv2050soft.easypaytest.data.network.retrofit.dto.LoginResponseDto
import com.avv2050soft.easypaytest.data.network.retrofit.dto.PaymentsResponseDto
import com.avv2050soft.easypaytest.domain.models.login.LoginResponse
import com.avv2050soft.easypaytest.domain.models.payments.PaymentsResponse

class RetrofitMapper {
    fun mapLoginResponseDtoToLoginResponse(loginResponseDto: LoginResponseDto): LoginResponse =
        LoginResponse(
            error = loginResponseDto.error,
            response = loginResponseDto.response,
            success = loginResponseDto.success
        )

    fun mapPaymentsResponseDtoToPaymentsResponse(paymentsResponseDto: PaymentsResponseDto): PaymentsResponse =
        PaymentsResponse(
            paymentItems = paymentsResponseDto.paymentItems,
            success = paymentsResponseDto.success
        )
}