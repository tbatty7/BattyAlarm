package com.example.battyalarm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import java.lang.Exception

class BattyAlarm: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        try {
            if ((Intent.ACTION_BOOT_COMPLETED).equals(intent?.getAction())) {
                // reset all alarms
            } else {
            showNotification(context, "Wake Up!", "Compose Notification")
            }

        } catch (ex: Exception) {
            Log.d("Receiving exception", "onReceive: ${ex.printStackTrace()}")
        }
    }

    private fun showNotification(context: Context, title: String, description: String ) {
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "message_channel"
        val channelName = "message_name"


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
            Log.d("*****", "***************** SDK Version greater than o")
        }

        val notification = NotificationCompat.Builder(context, channelId)
            .setContentTitle(title)
            .setContentText(description)
            .setSmallIcon(androidx.core.R.drawable.notification_template_icon_bg)
            .build()
        manager.notify(1, notification)
    }

}