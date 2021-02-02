package com.dwp.baseworkproj

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dwp.baseworkproj.extensions.plusAssign
import com.dwp.baseworkproj.util.DLog
import com.dwp.baseworkproj.util.NetworkStateMonitor

/**
 * Created by dwp on 2020-05-22.
 */

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Network 상태 모니터 서비스 라이프사이클 등록 및 시작
        val networkStatusMonitor =  NetworkStateMonitor(this)
        lifecycle += networkStatusMonitor
        networkStatusMonitor.enable()
        networkStatusMonitor.initNetworkCheck()
    }

}