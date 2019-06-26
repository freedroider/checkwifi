package com.spacewhale.wifitester.model

import android.content.Context
import com.github.pwittchen.reactivewifi.ReactiveWifi
import com.github.pwittchen.reactivewifi.WifiState
import com.spacewhale.wifitester.core.data.WifiZone
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WiFiScannerManager : WiFiScanner {

    override fun startWifiScanner(context: Context) = Observable.create<WifiZone> { emitter ->
        ReactiveWifi.observeWifiSignalLevel(context, WifiZone::class.nestedClasses.size)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ emitter.onNext(definitionZone(it)) }, emitter::onError)
    }

    override fun checkWifiConnection(context: Context) = Observable.create<WifiState> { emitter ->
        ReactiveWifi.observeWifiStateChange(context)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ emitter.onNext(it) }, emitter::onError)
    }

    private fun definitionZone(level: Int?) = when (level) {
        WifiZone.INDEFINITE().levelSignal -> WifiZone.INDEFINITE()
        WifiZone.LOW().levelSignal -> WifiZone.LOW()
        WifiZone.MODERATE().levelSignal -> WifiZone.MODERATE()
        WifiZone.HIGH().levelSignal -> WifiZone.HIGH()
        else -> WifiZone.INDEFINITE()
    }
}