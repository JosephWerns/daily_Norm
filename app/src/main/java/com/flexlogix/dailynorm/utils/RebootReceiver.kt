package com.flexlogix.dailynorm.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class RebootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.BOOT_COMPLETED") {
            AlarmUtils.setAlarm(context)
        }
    }
}