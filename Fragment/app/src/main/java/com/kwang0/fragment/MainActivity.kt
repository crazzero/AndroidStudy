package com.kwang0.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.navigation.NavigationBarView
import com.kwang0.fragment.databinding.MainActivityBinding
import com.kwang0.fragment.ui.first.FirstFragment
import com.kwang0.fragment.ui.second.SecondFragment
import com.kwang0.fragment.ui.third.ThirdFragment

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainNavigation.setOnItemSelectedListener(this)

        if (savedInstanceState == null) {

            // commit 비동기처리 && save state 에 자유롭지 않음
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.mainContainer, FirstFragment.newInstance())
//                .commit()
            // commit 동기처리 && save state 에 자유롭지 않음
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.mainContainer, FirstFragment.newInstance())
//                .commitNow()
            // commit 비동기처리 && save state 에 자유로움
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.mainContainer, FirstFragment.newInstance())
//                .commitAllowingStateLoss()
            // commit 동기처리 && save state 에 자유로움
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.mainContainer, FirstFragment.newInstance())
//                .commitNowAllowingStateLoss()

            // commit 비동기처리 된 친구들을 바로 실행시킬 때 사용
//            supportFragmentManager.executePendingTransactions()

            // stack 에 있는 fragment 을 비동기로 pop 시킴
//            supportFragmentManager.popBackStack()
            // stack 에 있는 fragment 을 동기로 pop 시킴
//            supportFragmentManager.popBackStack()
        }
    }

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item and false if the item should not be
     *     selected. Consider setting non-selectable items as disabled preemptively to make them
     *     appear non-interactive.
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer,
                when (item.itemId) {
                    R.id.first_item -> FirstFragment.newInstance()
                    R.id.second_item -> SecondFragment.newInstance()
                    R.id.third_item -> ThirdFragment.newInstance()
                    else -> error("Not Expected exception")
                }
            )
            .commit()
        return true
    }
}