package com.avv2050soft.easypaytest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.avv2050soft.easypaytest.databinding.ItemPaymentBinding
import com.avv2050soft.easypaytest.domain.models.payments.PaymentItem
import com.avv2050soft.easypaytest.ui.utils.toAmount
import com.avv2050soft.easypaytest.ui.utils.toDate

class PaymentsAdapter(

) : ListAdapter<PaymentItem, PaymentsAdapter.PaymentItemViewHolder>(DiffUtilPaymentItem()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentItemViewHolder {
        return PaymentItemViewHolder(
            ItemPaymentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PaymentItemViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            textViewId.text = item.id.toString()
            textViewTitle.text = item.title
            textViewAmount.text = item.amount?.toAmount() ?: "0.00"
            textViewCreated.text = item.created?.toDate("dd-MM-yyyy HH:mm") ?: "unknown"
        }
    }

    class PaymentItemViewHolder(val binding: ItemPaymentBinding) :
        RecyclerView.ViewHolder(binding.root)

    class DiffUtilPaymentItem : DiffUtil.ItemCallback<PaymentItem>() {
        override fun areItemsTheSame(oldItem: PaymentItem, newItem: PaymentItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PaymentItem, newItem: PaymentItem): Boolean =
            oldItem == newItem

    }
}