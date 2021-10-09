package com.kwang0.tdd.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.tdd.databinding.ActivityMainBinding
import com.kwang0.tdd.enum.ThemeMode
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var presenter: MainContract.Presenter

    private var count: Int = 0
        set(value) {
            field = value
            binding.textCount.text = value.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        binding.btnPlusOne.setOnClickListener {
            count++
        }
        binding.btnPlusTwo.setOnClickListener {
            count += 2
        }
        binding.btnMinusOne.setOnClickListener {
            count--
        }
        binding.btnMinusTwo.setOnClickListener {
            count -= 2
        }
    }

    override fun onResume() {
        super.onResume()
        count = presenter.getCount()
    }

    override fun onPause() {
        presenter.saveCount(count)
        super.onPause()
    }
}
