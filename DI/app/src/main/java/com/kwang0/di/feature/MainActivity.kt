package com.kwang0.di.feature

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kwang0.di.R
import com.kwang0.di.databinding.ActivityMainBinding
import com.kwang0.di.test.SomeClass
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var someClass: SomeClass
    private val mainViewModel : MainViewModel by viewModels()
    private var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        mainAdapter = MainAdapter().also {
            it.setItems(listOf("1", "2", "3"))
        }
        binding.recyclerMain.apply {
            itemAnimator = null
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }
    }
}
