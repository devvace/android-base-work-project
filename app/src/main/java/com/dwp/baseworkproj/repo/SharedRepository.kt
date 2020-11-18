package com.dwp.baseworkproj.repo

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

/**
 * Created by dwp on 2020-11-18.
 */

class SharedRepository(application: Application) {
    private val preferences: SharedPreferences =
        application.getSharedPreferences("default", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = preferences.edit()

    fun sharedPrefRemove(key: String) {
        editor.remove(key)
        editor.commit()
    }

    fun sharedPrefLoadString(key: String): String? = preferences.getString(key, "")

    fun sharedPrefLoadInteger(key: String): Int? = preferences.getInt(key, -1)

    fun sharedPrefLoadBoolean(key: String): Boolean? = preferences.getBoolean(key, false)

    fun sharedPrefSave(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun sharedPrefSave(key: String, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    fun sharedPrefSave(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }
}