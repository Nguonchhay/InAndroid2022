package com.nguonchhay.inandroid2022.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.inandroid2022.databinding.ActivityRoomDemoBinding

class RoomDemoActivity : AppCompatActivity() {

    lateinit var binding: ActivityRoomDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}