package com.dwp.baseworkproj.ui

import android.os.Bundle
import com.dwp.baseworkproj.BaseActivity
import com.dwp.baseworkproj.R
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        txt_test.text = sharedPrefStringLoad("test")
    }
}
