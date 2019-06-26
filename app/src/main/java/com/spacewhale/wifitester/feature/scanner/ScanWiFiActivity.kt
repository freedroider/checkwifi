package com.spacewhale.wifitester.feature.scanner

import android.os.Bundle
import androidx.fragment.app.commit
import com.spacewhale.wifitester.R
import com.spacewhale.wifitester.core.base.ToolbarActivity


class ScanWiFiActivity : ToolbarActivity() {

    override fun obtainResLayoutId() = R.layout.activity_scan_wifi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.commit {
            replace(R.id.frameScanner, ScanWiFiFragment())
        }
    }

    override fun onBackPressed() {
        finish()
    }
}