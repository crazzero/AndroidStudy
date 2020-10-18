package com.kwang0.layout.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.layout.R
import com.kwang0.layout.utils.IntentUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)

        moveToFrame.setOnClickListener { startLayoutActivity(FrameActivity::class.java) }
        moveToConstraint.setOnClickListener { startLayoutActivity(ConstraintActivity::class.java) }
        moveToRelative.setOnClickListener { startLayoutActivity(RelativeActivity::class.java) }
        moveToLinear.setOnClickListener { startLayoutActivity(LinearActivity::class.java) }
    }

    private fun startLayoutActivity(clazz: Class<*>) {
        IntentUtils(this).startActivity(clazz)
    }
}
