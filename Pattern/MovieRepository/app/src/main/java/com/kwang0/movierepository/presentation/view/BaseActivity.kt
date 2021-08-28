package com.kwang0.movierepository.presentation.view

import androidx.appcompat.app.AlertDialog
import com.kwang0.movierepository.R
import com.kwang0.movierepository.base.BaseView
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity(), BaseView {

    override fun showErrorMessage(message: String) {
        val builder = AlertDialog.Builder(this,
            R.style.Theme_AppCompat_Light_Dialog_Alert)
        builder.setMessage(message)
        builder.setPositiveButton(android.R.string.ok){ dialog, _ ->
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}
