package com.school_management_app.data.local.repository

import com.school_management_app.data.local.database.AppDatabase
import com.school_management_app.data.model.Post
import com.school_management_app.data.model.User

class LocalBaseRepository(private val db: AppDatabase) {
    //--------------POST ACTIONS-----------------------
    suspend fun upsertPostRecord(data: Post){
        db.appDao.insertOrUpdatePost(data)
    }

    suspend fun deletePostRecord(data: Post){
        db.appDao.deletePostRecord(data)
    }

    fun getPostRecords(){
        db.appDao.getPostRecords()
    }

    //--------------USER ACTIONS-----------------------
    suspend fun upsertUserRecord(data: User){
        db.appDao.insertOrUpdateUser(data)
    }

    suspend fun deletePostRecord(data: User){
        db.appDao.deleteUserRecord(data)
    }

    fun getUserRecords(){
        db.appDao.getUserRecords()
    }
}