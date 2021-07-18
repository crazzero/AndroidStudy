package com.kwang0.toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.kwang0.toast.helper.SystemToastHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSystemShortToast.setOnClickListener(this)
        buttonSystemShortGravityToast.setOnClickListener(this)
        buttonSystemLongToast.setOnClickListener(this)
        buttonSystemLongGravityToast.setOnClickListener(this)
        buttonCustomToast.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v) {
                buttonSystemShortToast -> {
                    SystemToastHelper.showShortToast(this, "Show Short Toast")
                }

                buttonSystemShortGravityToast -> {
                    SystemToastHelper.showShortToast(this, "Show Short Gravity Toast", Gravity.TOP or Gravity.START, 0 ,0)
                }

                buttonSystemLongToast -> {
                    SystemToastHelper.showLongToast(this, "Show Long Toast")
                }

                buttonSystemLongGravityToast -> {
                    SystemToastHelper.showLongToast(this, "Show Long Gravity Toast", Gravity.TOP or Gravity.END, 0 ,0)
                }

                // You can use tags for divide usage for showing toast
                // If you want to check this out, please remove upside code
                buttonSystemShortToast, buttonSystemShortGravityToast, buttonSystemLongToast, buttonSystemLongGravityToast -> {
                    SystemToastHelper.showToast(v, "Show Toast")
                }

                buttonCustomToast -> {
                    customToast.showCustomToast()
                }

                buttonSnack -> {
                    Snackbar.make(rootMainLayout, "This is Snack Bar", Snackbar.LENGTH_LONG).show();
                }
            }
        }
    }
}
