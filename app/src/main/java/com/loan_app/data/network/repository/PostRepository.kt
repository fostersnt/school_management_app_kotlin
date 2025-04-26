package com.loan_app.data.local.repository

import com.loan_app.data.model.ApiPostData
import com.loan_app.data.network.RetrofitInstance

class PostRepository {
    private val api = RetrofitInstance.api

    suspend fun getPost(id: Int) = api.getPostData(id)
    suspend fun getPosts() = api.getPosts()
    suspend fun savePostData(post: ApiPostData) = api.savePostData(post)
    suspend fun searchPost(query: String) = api.searchPost(query)
}
