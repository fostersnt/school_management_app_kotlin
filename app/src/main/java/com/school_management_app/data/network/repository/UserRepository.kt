package com.school_management_app.data.network.repository

import com.school_management_app.data.model.ApiPostData
import com.school_management_app.data.network.RetrofitInstance

class UserRepository {
    private val api = RetrofitInstance.api

    suspend fun fetchUser(id: Int) = api.fetchUser(id)
    suspend fun fetchUsers() = api.fetchUsers()
    suspend fun saveUser(user: ApiPostData) = api.saveUser(user)
    suspend fun searchUser(query: String) = api.searchUser(query)
}
