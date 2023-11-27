package com.avv2050soft.easypaytest.ui.payments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.avv2050soft.easypaytest.databinding.FragmentPaymentsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentsFragment : Fragment() {

    private val binding by viewBinding(FragmentPaymentsBinding::bind)
    private val paymentsViewModel by viewModels<PaymentsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}