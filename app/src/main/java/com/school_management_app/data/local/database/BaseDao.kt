package com.school_management_app.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.school_management_app.data.model.Post
import com.school_management_app.data.model.User

@Dao
interface BaseDao {
   //-----------POST ACTIONS ------------------
   @Upsert
   suspend fun insertOrUpdatePost(data: Post)

   @Delete
   suspend fun deletePostRecord(data: Post)

   @Query("SELECT * FROM posts")
   fun getPostRecords()

   //-----------USER ACTIONS ------------------
   @Upsert
   suspend fun insertOrUpdateUser(data: User)

   @Delete
   suspend fun deleteUserRecord(data: User)

   @Query("SELECT * FROM users")
   fun getUserRecords()
}