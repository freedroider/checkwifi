package com.spacewhale.wifitester.core.data

sealed class WifiZone(val levelSignal: Int) {
    class INDEFINITE : WifiZone(0)
    class LOW : WifiZone(1)
    class MODERATE : WifiZone(2)
    class HIGH : WifiZone(3)
}