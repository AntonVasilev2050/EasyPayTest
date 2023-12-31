package com.avv2050soft.easypaytest.ui.utils

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

fun Fragment.toastString(msg: String?) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}

inline fun <T> Flow<T>.launchAndCollectIn(
    owner: LifecycleOwner,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline action: suspend CoroutineScope.(T) -> Unit
) = owner.lifecycleScope.launch {
    owner.repeatOnLifecycle(minActiveState) {
        collect {
            action(it)
        }
    }
}


fun Int.toDate(formatString: String): String {
    val dateFormat = SimpleDateFormat(formatString, Locale.getDefault())
    return dateFormat.format(this * 1000)
}

fun String.toAmount(): String {
    return if (this.isNullOrBlank()) {
        "0.00"
    } else {
        this
    }
}