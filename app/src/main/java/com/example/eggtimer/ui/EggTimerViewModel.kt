package com.example.eggtimer.ui

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.concurrent.thread

class EggTimerViewModel : ViewModel(){

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
        _started.value = CookStatus.STOP
        Log.i("EggTimerViewModel","visible")

    }




}