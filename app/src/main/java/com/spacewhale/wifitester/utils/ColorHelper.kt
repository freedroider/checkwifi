package com.spacewhale.wifitester.utils

import android.graphics.Color
import com.spacewhale.wifitester.core.data.WifiZone

object ColorHelper {
    fun getColorBySignal(levelSignal: Int) = when (levelSignal) {
        WifiZone.INDEFINITE().levelSignal -> Color.WHITE
        WifiZone.LOW().levelSignal -> Color.RED
        WifiZone.MODERATE().levelSignal -> Color.YELLOW
        WifiZone.HIGH().levelSignal -> Color.GREEN
        else -> Color.WHITE
    }
}