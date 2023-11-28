package com.avv2050soft.easypaytest.ui.payments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.avv2050soft.easypaytest.R
import com.avv2050soft.easypaytest.databinding.FragmentPaymentsBinding
import com.avv2050soft.easypaytest.domain.TokenStorage
import com.avv2050soft.easypaytest.ui.adapters.PaymentsAdapter
import com.avv2050soft.easypaytest.ui.utils.launchAndCollectIn
import com.avv2050soft.easypaytest.ui.utils.toastString
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentsFragment : Fragment(R.layout.fragment_payments) {

    private val binding by viewBinding(FragmentPaymentsBinding::bind)
    private val paymentsViewModel by viewModels<PaymentsViewModel>()
    private val paymentsAdapter = PaymentsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        paymentsViewModel.paymentsResponseStateFlow.launchAndCollectIn(viewLifecycleOwner) {
            paymentsViewModel.getPaymentsResponse(TokenStorage.accessToken)
            it?.let {
                paymentsAdapter.submitList(it.paymentItems)
                binding.rvPayments.adapter = paymentsAdapter
            }
        }
    }
}