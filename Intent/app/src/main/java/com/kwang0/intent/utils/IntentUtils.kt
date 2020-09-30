package com.kwang0.intent.utils

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.kwang0.intent.extension.PhoneNumberHelper.getPhoneNumber

class IntentUtils(private val context: Context) {
    private var intent : Intent? = null

    fun start() {
        if (intent?.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }

    fun setExternalBrowser(url: String?): IntentUtils {
        url?.also {
            try {
                // Use set data
                intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(it))
            } catch (e: Exception) { }
        }
        return this
    }

    fun setWebSearch(query: String?): IntentUtils {
        query?.also {
            try {
                // Use put extra
                intent = Intent(Intent.ACTION_WEB_SEARCH).putExtra(SearchManager.QUERY, it)
            } catch (e: Exception) { }
        }
        return this
    }

    fun setEmail(email: String?): IntentUtils {
        email?.also {
            try {
                // Use intent constructor
                intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
            } catch (e: Exception) { }
        }
        return this
    }

    fun setPhoneCall(phone: String?): IntentUtils {
        phone?.also {
            try {
                // Use intent constructor
                intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
            } catch (e: Exception) { }
        }
        return this
    }

    fun setPhoneCallCountry(phone: String?): IntentUtils {
        phone?.also {
            try {
                // Use intent constructor
                intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${phone.getPhoneNumber()}"))
            } catch (e: Exception) { }
        }
        return this
    }

    fun setGeo(latitude: Float? = 0f, longitude: Float? = 0f, zoom: Int? = -1): IntentUtils {
        var temp = ""
        try {
            // Use data with apply
            intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(
                    when (zoom) {
                        -1 -> "geo:$latitude,$longitude"
                        else -> "geo:$latitude,$longitude?z=$zoom"
                    }
                )
            }
        } catch (e: Exception) { }
        return this
    }

    fun setWifiSettings(): IntentUtils {
        try {
            intent = Intent(Settings.ACTION_WIFI_SETTINGS)
        } catch (e: Exception) { }
        return this
    }
}
