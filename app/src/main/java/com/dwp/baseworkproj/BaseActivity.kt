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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        networkStatusMonitor = NetworkStateMonitor(this)
        networkStatusMonitor.enable()
    }

    fun sharedPrefSave(key: String, value: String) {
        BaseApplication.instance?.sharedPrefSave(this, key, value)
    }

    fun sharedPrefSave(key: String, value: Int) {
        BaseApplication.instance?.sharedPrefSave(this, key, value)
    }

    fun sharedPrefSave(key: String, value: Boolean) {
        BaseApplication.instance?.sharedPrefSave(this, key, value)
    }

    fun sharedPrefStringLoad(key: String): String? {
        return BaseApplication.instance?.sharedPrefStringLoad(this, key)
    }

    fun sharedPrefIntegerLoad(key: String): Int? {
        return BaseApplication.instance?.sharedPrefIntegerLoad(this, key)
    }

    fun sharedPrefBooleanLoad(key: String): Boolean? {
        return BaseApplication.instance?.sharedPrefBooleanLoad(this, key)
    }

    fun getNetworkStatus(): Int {
        return BaseApplication.instance!!.getNetworkStatus(this)
    }

    fun isShowNetworkDialog(state: Boolean) {
        if(state) {
            BaseApplication.instance?.dialogNetworkLoadingOn(this)
        } else {
            BaseApplication.instance?.dialogNetworkLoadingOff()
        }
    }
}