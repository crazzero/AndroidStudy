package com.kwang0.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kwang0.intent.utils.IntentUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonExternalBrowser.setOnClickListener {
            IntentUtils().setExternalBrowser(this, Const.EXTERNAL_BROWSER_SAMPLE).start()
        }

        buttonPhoneCall.setOnClickListener {
            IntentUtils().setPhoneCall(this, Const.PHONE_CALL_SAMPLE).start()
        }

        buttonEmail.setOnClickListener {
            IntentUtils().setEmail(this, Const.EMAIL_SAMPLE).start()
        }
    }
}
