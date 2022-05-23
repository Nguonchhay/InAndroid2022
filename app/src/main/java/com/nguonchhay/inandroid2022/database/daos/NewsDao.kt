package com.nguonchhay.inandroid2022.database.daos

import androidx.room.*
import com.nguonchhay.inandroid2022.database.entities.NewsEntity

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun list(): List<NewsEntity>

    @Insert
    fun store(news: NewsEntity)

    @Update
    fun update(news: NewsEntity)

    @Delete
    fun remove(news: NewsEntity)
}