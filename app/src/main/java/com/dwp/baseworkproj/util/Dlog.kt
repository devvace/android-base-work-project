package com.dwp.baseworkproj.util

import android.util.Log
import com.dwp.baseworkproj.BaseApplication
import java.lang.StringBuilder

/**
 * Created by dwp on 2020-05-22.
 **/

class Dlog {
    companion object {
        private const val TAG = "DWPARK"
        fun e(message: String) {
            if(BaseApplication.DEBUG) Log.e(TAG, buildLogMsg(message))
        }

        fun w(message: String) {
            if(BaseApplication.DEBUG) Log.w(TAG, buildLogMsg(message))
        }

        fun i(message: String) {
            if(BaseApplication.DEBUG) Log.i(TAG, buildLogMsg(message))
        }

        fun d(message: String) {
            if(BaseApplication.DEBUG) Log.d(TAG, buildLogMsg(message))
        }

        fun v(message: String) {
            if(BaseApplication.DEBUG) Log.v(TAG, buildLogMsg(message))
        }

        private fun buildLogMsg(message: String): String {
            val ste : StackTraceElement = Thread.currentThread().stackTrace[4]
            val sb = StringBuilder()
            sb.append("[")
            sb.append(ste.fileName.replace(".java", ""))
            sb.append("::")
            sb.append(ste.methodName)
            sb.append("]")
            sb.append(message)

            return sb.toString()
        }
    }
}