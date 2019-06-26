package com.spacewhale.wifitester.core.base

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxStateStore
import com.airbnb.mvrx.RealMvRxStateStore
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<S : MvRxState>(
    initialState: S,
    debugMode: Boolean,
    stateStore: MvRxStateStore<S> = RealMvRxStateStore(initialState)
) : BaseMvRxViewModel<S>(initialState, debugMode, stateStore) {
    val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}