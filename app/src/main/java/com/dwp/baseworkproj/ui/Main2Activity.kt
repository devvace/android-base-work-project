package com.dwp.baseworkproj.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dwp.baseworkproj.BaseActivity
import com.dwp.baseworkproj.databinding.ActivityMain2Binding
import com.dwp.baseworkproj.vm.Main2ViewModel

class Main2Activity : BaseActivity() {
    private lateinit var binding: ActivityMain2Binding
    private val main2ViewModel: Main2ViewModel by lazy {
        ViewModelProvider(this).get(Main2ViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTest.text = main2ViewModel.sharedPrefLoad("test")
    }
}
