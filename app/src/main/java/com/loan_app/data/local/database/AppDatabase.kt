package com.loan_app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.loan_app.data.model.Post
import com.loan_app.data.model.User

@Database(entities = [Post::class, User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
abstract val  appDao: BaseDao
}