package com.kwang0.di.feature

import android.os.Bundle
import com.kwang0.di.databinding.ActivitySecondBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

class SecondActivity : BaseActivity(), SecondContract.View {

    private lateinit var binding: ActivitySecondBinding
    private val presenter: SecondContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        binding.textSecond.setOnClickListener {
            presenter.onClicked()
        }
    }

    override fun setSecondText(value: String) {
        binding.textSecond.text = value
    }
}

val secondActivityModule = module {
    factory<SecondContract.Presenter> { (view: SecondContract.View) -> SecondPresenter(view) }
}
