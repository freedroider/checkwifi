package com.spacewhale.wifitester.core.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    @LayoutRes
    abstract fun obtainResLayoutId(): Int
}