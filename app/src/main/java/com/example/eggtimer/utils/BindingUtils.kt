package com.example.eggtimer.utils

import android.util.Log
import android.view.View
import android.widget.Button
import androidx.databinding.BindingAdapter
import com.example.eggtimer.ui.EggTimerViewModel

@BindingAdapter("StartButtonVisiblity")
fun visiblity(button : Button, cook : EggTimerViewModel.CookStatus?){
    when(cook){
        EggTimerViewModel.CookStatus.START -> {
            Log.i("BindingAdaper","invisible")
            button.visibility = View.INVISIBLE
        }
        EggTimerViewModel.CookStatus.STOP -> {
            Log.i("BindingAdaper","visible")
            button.visibility = View.VISIBLE
        }
    }
}