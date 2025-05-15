package com.school_management_app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val url: String,
    val title: String,
    val content: String
)
