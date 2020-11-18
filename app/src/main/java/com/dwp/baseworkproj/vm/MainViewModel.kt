package com.dwp.baseworkproj.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.dwp.baseworkproj.repo.SharedRepository

/**
 * Created by dwp on 2020-11-18.
 */

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = SharedRepository(application)

    fun sharedPrefSave(key: String, value: String) {
        repository.sharedPrefSave(key, value)
    }
}