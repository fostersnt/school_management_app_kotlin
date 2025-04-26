package com.loan_app.data.repository_base

interface DatabaseOperations {
    suspend fun getSingleData(id: Int)
    suspend fun getRangeOfData(minId: Int, maxId: Int)
    suspend fun getAllData()
    suspend fun deleteSingleData(id: Int)
}