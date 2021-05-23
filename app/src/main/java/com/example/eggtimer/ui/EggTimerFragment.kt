package com.example.eggtimer.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.eggtimer.R
import com.example.eggtimer.databinding.FragmentEggTimerBinding


class EggTimerFragment : Fragment() {

    private lateinit var binding: FragmentEggTimerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_egg_timer, container, false)
        return binding.root
    }


}