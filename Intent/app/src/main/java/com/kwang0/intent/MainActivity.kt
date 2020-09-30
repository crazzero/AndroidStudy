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
            IntentUtils(this).setExternalBrowser(Const.EXTERNAL_BROWSER_SAMPLE).start()
        }

        buttonWebSearch.setOnClickListener {
            IntentUtils(this).setWebSearch(Const.WEB_SEARCH)
        }

        buttonPhoneCall.setOnClickListener {
            IntentUtils(this).setPhoneCall(Const.PHONE_CALL_SAMPLE).start()
        }

        buttonPhoneCallCountry.setOnClickListener {
            IntentUtils(this).setPhoneCallCountry(Const.PHONE_CALL_SAMPLE).start()
        }

        buttonEmail.setOnClickListener {
            IntentUtils(this).setEmail(Const.EMAIL_SAMPLE).start()
        }

        buttonGeoDefault.setOnClickListener {
            IntentUtils(this).setGeo(Const.SEOUL_LATITUDE, Const.SEOUL_LONGITUDE)
        }

        buttonGeoZoom.setOnClickListener {
            IntentUtils(this).setGeo(Const.SEOUL_LATITUDE, Const.SEOUL_LONGITUDE, 5)
        }

        buttonWifiSettings.setOnClickListener {
            IntentUtils(this).setWifiSettings()
        }
    }
}
