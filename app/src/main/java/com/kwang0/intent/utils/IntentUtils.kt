package com.kwang0.intent.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

object IntentUtils {
    fun startExternalBrowser(context: Context, url: String?) {
        url?.also {
            try {
                val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(it))
                context.startActivity(intent)
            } catch (e: Exception) { }
        }
    }

    fun startEmail(context: Context, email: String?) {
        email?.also {
            try {
                val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
                context.startActivity(intent)
            } catch (e: Exception) { }
        }
    }

    fun startPhoneCall(context: Context, phone: String?) {
        phone?.also {
            try {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                context.startActivity(intent)
            } catch (e: Exception) { }
        }
    }
}
