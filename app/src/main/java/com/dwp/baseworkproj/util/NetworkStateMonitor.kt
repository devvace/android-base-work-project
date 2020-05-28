package com.dwp.baseworkproj.util

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.dwp.baseworkproj.BaseApplication

/**
 * Created by dwp on 2020-05-25.
 */

class NetworkStateMonitor(activity: Activity): ConnectivityManager.NetworkCallback() {
    private lateinit var connectivityManager: ConnectivityManager
    var activityContext: Activity = activity

    /** Network를 감지할 Capabilities 선언 **/
    private val networkRequest: NetworkRequest = NetworkRequest.Builder()
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .build()

    /** Network 모니터링 서비스 시작 **/
    fun enable() {
        connectivityManager =  activityContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.registerNetworkCallback(networkRequest, this)
    }

    /** Network가 Available 상태이면 Call **/
    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        // Do what you need to do here
        Dlog.i("networkAvailable()")
        BaseApplication.instance?.dialogNetworkLoadingOff()
    }

    /** Network가 Available 상태에서 Unavailable로 변경되면 Call
     * 처음 앱 시작시 Unavailable 인지는 캐치하지 못 함 **/
    override fun onLost(network: Network) {
        super.onLost(network)
        Dlog.i("networkUnavailable()")
        BaseApplication.instance?.dialogNetworkLoadingOn(activityContext)
    }

}