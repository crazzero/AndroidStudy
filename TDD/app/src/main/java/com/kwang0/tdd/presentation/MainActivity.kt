package com.kwang0.tdd.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.tdd.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding

    @Inject
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        presenter.fetch()
    }

    override fun onFetchResult() {
    }
}
