package com.nguonchhay.inandroid2022.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.nguonchhay.inandroid2022.database.NewsDatabase
import com.nguonchhay.inandroid2022.database.entities.NewsEntity
import com.nguonchhay.inandroid2022.databinding.ActivityRoomDemoBinding

class RoomDemoActivity : AppCompatActivity() {

    lateinit var binding: ActivityRoomDemoBinding
    lateinit var dbInstance: NewsDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbInstance = NewsDatabase.getInstance(applicationContext)

        binding.btnNewsList.setOnClickListener {
            val newsData = dbInstance.newsDao.list()
            var ids = "All IDs => "
            newsData.forEach {
                ids += ", ${it.id}"
                Log.d("RoomDemoActivity", it.toString())
            }
            Toast.makeText(this@RoomDemoActivity, ids, Toast.LENGTH_SHORT).show()
        }

        binding.btnNewsStore.setOnClickListener {
            dbInstance.newsDao.store(NewsEntity(
                title = "Title 1",
                image = "Image 1",
                desc = "Desc 1"
            ))
        }
    }
}