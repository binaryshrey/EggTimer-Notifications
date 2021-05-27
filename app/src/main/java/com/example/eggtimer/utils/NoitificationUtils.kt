package com.example.eggtimer.utils

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.example.eggtimer.R

val NOTIFICATION_ID = 0

fun NotificationManager.sendNotification(messageBody:String, applicationContext : Context){

    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.egg_notification_channel_id)
    )
        .setSmallIcon(R.drawable.cooked_egg)
        .setContentTitle(applicationContext.getString(R.string.notificationTitle))
        .setContentText(messageBody)
        .setPriority(NotificationManager.IMPORTANCE_HIGH)

    notify(NOTIFICATION_ID,builder.build())
}