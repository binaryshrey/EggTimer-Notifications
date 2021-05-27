package com.example.eggtimer.utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.eggtimer.MainActivity
import com.example.eggtimer.R

val NOTIFICATION_ID = 0

fun NotificationManager.sendNotification(messageBody:String, applicationContext : Context){
    
    val contentIntent = Intent(applicationContext,MainActivity::class.java)
    val contentPendingIntent = PendingIntent.getActivity(
        applicationContext,
        NOTIFICATION_ID,
        contentIntent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )

    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.egg_notification_channel_id)
    )
        .setSmallIcon(R.drawable.cooked_egg)
        .setContentTitle(applicationContext.getString(R.string.notificationTitle))
        .setContentText(messageBody)
        .setPriority(NotificationManager.IMPORTANCE_HIGH)
        .setContentIntent(contentPendingIntent)
        .setAutoCancel(true)

    notify(NOTIFICATION_ID,builder.build())
}