package com.flexlogix.dailynorm.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import com.flexlogix.dailynorm.activities.MainActivity
import com.flexlogix.dailynorm.R
import com.flexlogix.dailynorm.activities.QuoteActivity

object NotificationUtil {
    private const val CHANNEL_ID = "NORM"
    private const val notificationId = 101

    // Create Notification channel
    fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context.getString(R.string.channel_name)
            val descriptionText = context.getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val notificationChannel = NotificationChannel(CHANNEL_ID, name, importance)
                .apply {
                    description = descriptionText
                    enableLights(true)
                    lightColor = Color.GREEN
                    enableVibration(true)
            }
            // Register the channel with the system
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    // Create daily notification
    fun createNotification(context: Context) {
        createNotificationChannel(context)
        val intent = Intent(context, QuoteActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_norm_24)
            .setContentTitle("Norm Quote")
            .setContentText("Daily bit of wisdom from Norm MacDonald")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE)
            as NotificationManager

        notificationManager.notify(notificationId, builder.build())

    }
}









