package com.kwang0.fragment

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView
import com.kwang0.fragment.databinding.MainActivityBinding
import com.kwang0.fragment.ui.first.FirstFragment
import com.kwang0.fragment.ui.second.SecondFragment
import com.kwang0.fragment.ui.third.ThirdFragment

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: MainActivityBinding
    private var firstFragment = FirstFragment.newInstance()
    private var secondFragment = SecondFragment.newInstance()
    private var thirdFragment = ThirdFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainNavigation.setOnItemSelectedListener(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.mainContainer, firstFragment)
            .commit()

        // 불필요한 작업을 취소시켜주게 만들어줌
//        supportFragmentManager.beginTransaction()
//            .setReorderingAllowed(true)

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
        val selectedFragment = when (item.itemId) {
            R.id.first_item -> firstFragment
            R.id.second_item -> secondFragment
            R.id.third_item -> thirdFragment
            else -> error("Not Expected exception")
        }

        supportFragmentManager.beginTransaction().also {
            if (supportFragmentManager.fragments.contains(selectedFragment)) {
                it.show(selectedFragment)
            } else {
                it.add(R.id.mainContainer, selectedFragment)
            }
        }.commit()

        supportFragmentManager.fragments.filter { it != selectedFragment }.forEach {
            supportFragmentManager.beginTransaction()
                .hide(it)
                .commit()
        }

        return true
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it.isVisible) {
                val childFragment = it.childFragmentManager
                if (childFragment.backStackEntryCount > 0) {
                    childFragment.popBackStack()
                    return
                }
            }
        }
        super.onBackPressed()
    }
}
