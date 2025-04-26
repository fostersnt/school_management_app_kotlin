package com.loan_app.data.repository_base

interface ApiOperations {
    suspend fun fetch_Api_SingleData(id: Int)
    suspend fun fetch_Api_RangeOfData(minId: Int, maxId: Int)
    suspend fun fetch_Api_AllData()
    suspend fun delete_Api_SingleData(id: Int)
    suspend fun search_Api_Data(searchText: String)
}