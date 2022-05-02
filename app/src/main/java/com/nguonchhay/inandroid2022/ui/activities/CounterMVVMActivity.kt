package com.nguonchhay.inandroid2022.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nguonchhay.inandroid2022.databinding.ActivityCounterMvvmactivityBinding
import com.nguonchhay.inandroid2022.ui.viewmodels.CounterViewModel

class CounterMVVMActivity : AppCompatActivity() {

    lateinit var binding: ActivityCounterMvvmactivityBinding
    lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterMvvmactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        counterViewModel.counterState.observe(this, Observer {
            binding.tvCount.text = it.toString()
        })

        binding.btnIncrease.setOnClickListener {
            counterViewModel.increase()
        }

        binding.btnDecrease.setOnClickListener {
            counterViewModel.decrease()
        }
    }
}