package com.example.eggtimer.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.eggtimer.R
import com.example.eggtimer.databinding.FragmentEggTimerBinding


class EggTimerFragment : Fragment() {

    private lateinit var binding: FragmentEggTimerBinding
    private lateinit var viewModel: EggTimerViewModel
    private lateinit var viewModelFactory: EggTimerViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_egg_timer, container, false)
        val application = requireNotNull(activity).application
        viewModelFactory = EggTimerViewModelFactory(application)
        viewModel = ViewModelProvider(this,viewModelFactory).get(EggTimerViewModel::class.java)
        binding.eggTimerViewModel = viewModel

        binding.lifecycleOwner = this

        createChannel(getString(R.string.egg_notification_channel_id),getString(R.string.channelName))
        return binding.root
    }

    fun createChannel(channelId : String, channelName : String){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelName,
                channelId,
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.enableVibration(true)
            notificationChannel.lightColor = Color.BLUE
            notificationChannel.description = "Time for breakfast"
            val notificationManager = requireActivity().getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(notificationChannel)
        }

    }

    override fun onResume() {
        super.onResume()
        val adapter = ArrayAdapter(requireContext(),R.layout.dropdown_list_item,resources.getStringArray(R.array.egg_array))
        binding.autoCompleteTextView.setAdapter(adapter)

    }
}