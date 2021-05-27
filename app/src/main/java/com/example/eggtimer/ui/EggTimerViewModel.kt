package com.example.eggtimer.ui

import android.app.Application
import android.app.NotificationManager
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eggtimer.R
import com.example.eggtimer.utils.cancelNotifiaction
import com.example.eggtimer.utils.sendNotification
import kotlin.concurrent.thread

class EggTimerViewModel(private val app: Application) : AndroidViewModel(app){

    enum class CookStatus { START, STOP }

    private val _started = MutableLiveData<CookStatus>()
    val started : LiveData<CookStatus>
    get() = _started

    init {
        _started.value = CookStatus.STOP
    }

    fun onStart(){
        Log.i("EggTimerViewModel","invisible")

        _started.value = CookStatus.START
        Thread.sleep(5_000)
        val notificationManager = ContextCompat.getSystemService(
            app,
            NotificationManager::class.java
        ) as NotificationManager
        notificationManager.cancelNotifiaction()
        notificationManager.sendNotification(app.getString(R.string.timer_running), app)
        _started.value = CookStatus.STOP
        Log.i("EggTimerViewModel","visible")

    }




}