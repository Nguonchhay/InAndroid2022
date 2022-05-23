package com.nguonchhay.inandroid2022.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
class NewsEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val desc: String
) {

    public override fun toString(): String {
        return "$id, $image, $title, $desc"
    }
}