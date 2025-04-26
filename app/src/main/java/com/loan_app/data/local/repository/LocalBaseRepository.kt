package com.loan_app.data.local.repository

import com.loan_app.data.local.database.AppDatabase

class LocalBaseRepository<T>(private val db: AppDatabase<T>) {
    suspend fun upsertData(dataItem: T){
        db.AppDao.insertOrUpdate(dataItem)
    }

    suspend fun deleteRecord(dataItem: T){
        db.AppDao.deleteRecord(dataItem)
    }

    fun getAllDataItems(){
        db.AppDao.retrieveRecords()
    }
}