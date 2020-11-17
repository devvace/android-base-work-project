package com.dwp.baseworkproj.ui

import android.content.Intent
import android.os.Bundle
import com.dwp.baseworkproj.BaseActivity
import com.dwp.baseworkproj.databinding.ActivityMainBinding
import com.dwp.baseworkproj.util.Dlog

/**
 * Created by dwp on 2020-05-22.
 */

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Dlog.e("----> MainActivity 시작 !")

        // 최초 실행시 Disconnect 상태인지 체크, NetworkCallback()은 최초 Disconnect 감지가 안됨
        if(getNetworkStatus() == 0) {
            isShowNetworkDialog(true)
        }

        // TODO : 다른 엑티비티로 이동 테스트
        binding.btGoMain2activity.setOnClickListener {
            sharedPrefSave("test", "save?")

            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }
}
