package com.kwang0.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kwang0.fragment.databinding.MainActivityBinding
import com.kwang0.fragment.ui.first.FirstFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {

            // commit 비동기처리 && save state 에 자유롭지 않음
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, FirstFragment.newInstance())
//                .commit()
            // commit 동기처리 && save state 에 자유롭지 않음
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, FirstFragment.newInstance())
//                .commitNow()
            // commit 비동기처리 && save state 에 자유로움
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, FirstFragment.newInstance())
//                .commitAllowingStateLoss()
            // commit 동기처리 && save state 에 자유로움
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, FirstFragment.newInstance())
//                .commitNowAllowingStateLoss()

            // commit 비동기처리 된 친구들을 바로 실행시킬 때 사용
//            supportFragmentManager.executePendingTransactions()

            // stack 에 있는 fragment 을 비동기로 pop 시킴
//            supportFragmentManager.popBackStack()
            // stack 에 있는 fragment 을 동기로 pop 시킴
//            supportFragmentManager.popBackStack()
        }
    }
}