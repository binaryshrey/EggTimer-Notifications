package com.example.eggtimer.ui

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_egg_timer, container, false)
        viewModel = ViewModelProvider(this).get(EggTimerViewModel::class.java)
        binding.eggTimerViewModel = viewModel
        binding.lifecycleOwner = this


        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val adapter = ArrayAdapter(requireContext(),R.layout.dropdown_list_item,resources.getStringArray(R.array.egg_array))
        binding.autoCompleteTextView.setAdapter(adapter)

    }
}