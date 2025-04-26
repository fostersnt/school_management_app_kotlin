package com.loan_app.data.local.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.loan_app.data.model.Post
import com.loan_app.data.model.User
import com.loan_app.data.repository_base.DatabaseOperations

@Dao
interface BaseDao <T> {
   @Upsert
   suspend fun insertOrUpdate(item: T)

   @Delete
   suspend fun deleteRecord(item: T)

   @Query("SELECT * FROM users")
   fun retrieveRecords()
}