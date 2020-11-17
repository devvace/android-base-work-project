package com.dwp.baseworkproj.ui

import android.os.Bundle
import com.dwp.baseworkproj.BaseActivity
import com.dwp.baseworkproj.databinding.ActivityMain2Binding

class Main2Activity : BaseActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTest.text = sharedPrefStringLoad("test")
    }
}
