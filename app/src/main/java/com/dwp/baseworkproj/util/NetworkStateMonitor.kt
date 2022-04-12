package com.dwp.baseworkproj.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*

/**
 * Created by dwp on 2020-05-25.
 */


class NetworkStateMonitor(private val lifecycleOwner: AppCompatActivity):
    ConnectivityManager.NetworkCallback(),
    DefaultLifecycleObserver {

    private val connectivityManager = lifecycleOwner.getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager

    /** Network를 감지할 Capabilities 선언 **/
    private val networkRequest: NetworkRequest = NetworkRequest.Builder()
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .build()


    /** 최초 앱 실행시 네트워크 상태 체크 **/
    private fun initNetworkCheck() {
        val activeNetwork = connectivityManager.activeNetwork
        if(activeNetwork != null) {
            DLog.e("네트워크 연결되어 있음")
        } else {
            DLog.e("네트워크 연결되어 있지않음")
        }
    }

    /** Network 모니터링 서비스 시작 **/
    private fun enable() {
        check(lifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED))
        connectivityManager.registerNetworkCallback(networkRequest, this)
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        enable()
        initNetworkCheck()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        // Network 모니터링 서비스 종료
        connectivityManager.unregisterNetworkCallback(this)
        lifecycleOwner.lifecycle.removeObserver(this)
    }

    /** Network가 Available 상태이면 Call **/
    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        DLog.i("networkAvailable()")
    }

    /** Network가 Available 상태에서 Unavailable로 변경되면 Call
     * 처음 앱 시작시 Unavailable 인지는 캐치하지 못 함 **/
    override fun onLost(network: Network) {
        super.onLost(network)
        DLog.i("networkUnavailable()")
    }

}