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
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        binding.btnSystemTheme.setOnClickListener {
            presenter.fetchTheme(ThemeMode.SYSTEM)
        }
        binding.btnLightTheme.setOnClickListener {
            presenter.fetchTheme(ThemeMode.LIGHT)
        }
        binding.btnDarkTheme.setOnClickListener {
            presenter.fetchTheme(ThemeMode.DARK)
        }
    }
}
