package com.dwp.baseworkproj.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.dwp.baseworkproj.repo.SharedRepository

/**
 * Created by dwp on 2020-11-18.
 */

class Main2ViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = SharedRepository(application)

    fun sharedPrefLoad(key: String): String? = repository.sharedPrefLoadString(key)
}