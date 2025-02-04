package com.mokelab.android16demo.predictive_back

import android.app.Activity
import android.os.Bundle
import android.window.OnBackInvokedCallback
import android.window.OnBackInvokedDispatcher
import androidx.appcompat.app.AppCompatActivity

class BackActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onBackInvokedDispatcher.registerOnBackInvokedCallback(
            OnBackInvokedDispatcher.PRIORITY_DEFAULT,
            object : OnBackInvokedCallback {
                override fun onBackInvoked() {
                    finishAndRemoveTask()
                }
            })
    }
}
