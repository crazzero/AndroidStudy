package com.kwang0.intent.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

class IntentUtils() {
    private var context: Context? = null
    private var intent : Intent? = null

    fun start() {
        context?.also {
            if (intent?.resolveActivity(it.packageManager) != null) {
                context?.startActivity(intent)
            }
        }
    }

    fun setExternalBrowser(context: Context, url: String?): IntentUtils {
        this.context = context
        url?.also {
            try {
                intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(it))
            } catch (e: Exception) { }
        }
        return this
    }

    fun setEmail(context: Context, email: String?): IntentUtils {
        this.context = context
        email?.also {
            try {
                intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
            } catch (e: Exception) { }
        }
        return this
    }

    fun setPhoneCall(context: Context, phone: String?): IntentUtils {
        this.context = context
        phone?.also {
            try {
                intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
            } catch (e: Exception) { }
        }
        return this
    }
}
