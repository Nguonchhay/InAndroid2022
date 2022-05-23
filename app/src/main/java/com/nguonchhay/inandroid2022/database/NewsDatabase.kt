package com.nguonchhay.inandroid2022.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nguonchhay.inandroid2022.database.daos.NewsDao
import com.nguonchhay.inandroid2022.database.entities.NewsEntity

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract val newsDao: NewsDao

    companion object {
        @Volatile
        private var INSTANCE: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java,
                        "newsapp"
                    )
                    .allowMainThreadQueries()
                    .build()
                }

                return instance
            }
        }
    }
}