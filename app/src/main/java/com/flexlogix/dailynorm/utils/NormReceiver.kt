package com.flexlogix.dailynorm.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NormReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "NORM_DAILY_ALARM") {
            NotificationUtil.createNotification(context)
        }
    }
}