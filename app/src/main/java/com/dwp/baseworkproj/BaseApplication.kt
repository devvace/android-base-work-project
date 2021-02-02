package com.dwp.baseworkproj

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import com.dwp.baseworkproj.extensions.plusAssign
import com.dwp.baseworkproj.util.DLog
import com.dwp.baseworkproj.util.NetworkStateMonitor

/**
 * Created by dwp on 2020-05-22.
 */

class BaseApplication : Application() {
    companion object {
        var DEBUG = false
        var instance: BaseApplication? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        DEBUG = isDebuggable(this)
    }

    /** Debug인지 Release인지 판단해서 Release상태이면 Log를 출력하지 않게 **/
    private fun isDebuggable(context : Context): Boolean {
        var debuggable = false
        val pm = context.packageManager
        try {
            val appInfo = pm.getApplicationInfo(context.packageName, 0)
            debuggable = 0 != appInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return debuggable
    }
}