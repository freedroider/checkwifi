package com.spacewhale.wifitester.core.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import com.airbnb.mvrx.BaseMvRxFragment

abstract class BaseFragment : BaseMvRxFragment() {
    fun shortToast(@StringRes messageId: Int) {
        Toast.makeText(requireContext(), messageId, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}