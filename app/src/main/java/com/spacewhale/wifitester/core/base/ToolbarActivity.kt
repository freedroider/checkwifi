package com.spacewhale.wifitester.core.base

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.spacewhale.wifitester.R

abstract class ToolbarActivity : BaseActivity() {
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar = findViewById(R.id.toolbar)
        toolbar.apply {
            navigationIcon = getDrawable(R.drawable.ic_close)
            title = getString(R.string.cancel)
            setNavigationOnClickListener { onBackPressed() }
        }
    }
}