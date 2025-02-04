package com.mokelab.android16demo.predictive_back

import android.app.Activity
import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import android.window.SystemOnBackInvokedCallbacks

import androidx.appcompat.app.AppCompatActivity

class BackActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dispatcher: OnBackInvokedDispatcher = this.onBackInvokedDispatcher
        dispatcher.registerOnBackInvokedCallback(
            OnBackInvokedDispatcher.PRIORITY_DEFAULT,
            SystemOnBackInvokedCallbacks.moveTaskToBackCallback(this)
        )
    }
}