package com.nguonchhay.inandroid2022.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.inandroid2022.databinding.ActivityNewsDetailBinding

class NewsDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val image: Int = bundle!!.getString("NEWS_IMAGE")!!.toInt()
        binding.newsImage.setImageResource(image)

        val title: String = bundle!!.getString("NEWS_TITLE").toString()
        binding.newsTitle.text = title

        val desc: String = bundle!!.getString("NEWS_DESC").toString()
        binding.newsDesc.text = desc
    }
}