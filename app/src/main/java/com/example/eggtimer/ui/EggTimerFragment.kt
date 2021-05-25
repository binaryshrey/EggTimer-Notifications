package com.example.eggtimer.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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

        val egg_array = arrayOf("Test only, better not use it for cooking :)","Soft Boiled","Slightly Firmer","Firm Yolk","Hard Boiled")


        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val adapter = ArrayAdapter(requireContext(),R.layout.dropdown_list_item,resources.getStringArray(R.array.egg_array))
        binding.autoCompleteTextView.setAdapter(adapter)

    }
}