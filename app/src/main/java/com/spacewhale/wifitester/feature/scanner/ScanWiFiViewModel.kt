package com.spacewhale.wifitester.feature.scanner

import android.content.Context
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.github.pwittchen.reactivewifi.WifiState
import com.spacewhale.wifitester.core.base.BaseViewModel
import com.spacewhale.wifitester.core.data.WifiSignal
import com.spacewhale.wifitester.model.WiFiScanner
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject

class ScanWiFiViewModel(wifiSignal: WifiSignal, private val wifiScanner: WiFiScanner) :
    BaseViewModel<WifiSignal>(wifiSignal, debugMode = true) {
    companion object : MvRxViewModelFactory<ScanWiFiViewModel, WifiSignal> {
        override fun create(viewModelContext: ViewModelContext, state: WifiSignal): ScanWiFiViewModel? {
            val wifiScanner: WiFiScanner by viewModelContext.activity.inject()
            return ScanWiFiViewModel(state, wifiScanner)
        }
    }

    fun checkWifi(context: Context) {
        val disposable = wifiScanner.checkWifiConnection(context)
            .subscribeOn(Schedulers.io())
            .execute { wifiState ->
                wifiState.invoke()?.description?.let { state ->
                    if (state == WifiState.DISABLED.description) {
                        copy(zone = Uninitialized)
                    } else {
                        copy(zone = zone)
                    }
                } ?: copy(zone = zone)
            }
        compositeDisposable.add(disposable)
    }

    fun startObservationOfSignal(context: Context) {
        val disposable = wifiScanner.startWifiScanner(context)
            .subscribeOn(Schedulers.io())
            .execute { copy(zone = it) }
        compositeDisposable.add(disposable)
    }
}