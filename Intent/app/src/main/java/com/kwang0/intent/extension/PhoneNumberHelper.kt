package com.kwang0.intent.extension

import android.os.Build
import android.telephony.PhoneNumberUtils
import java.util.*

object PhoneNumberHelper {
    fun String.getPhoneNumber(country: String? = Locale.getDefault().country): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            PhoneNumberUtils.formatNumber(this, country);
        } else {
            PhoneNumberUtils.formatNumber(this);
        }
    }
}