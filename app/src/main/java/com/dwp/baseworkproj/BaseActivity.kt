package com.dwp.baseworkproj

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dwp.baseworkproj.util.NetworkStateMonitor

/**
 * Created by dwp on 2020-05-22.
 */

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    private lateinit var networkStatusMonitor: NetworkStateMonitor

    override fun onResume() {
        super.onResume()
        networkStatusMonitor = NetworkStateMonitor(this)
        networkStatusMonitor.enable()
    }
}