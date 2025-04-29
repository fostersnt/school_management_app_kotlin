package com.loan_app.data.local.repository

import com.loan_app.data.model.ApiPostData
import com.loan_app.data.network.RetrofitInstance

class PostRepository {
    private val api = RetrofitInstance.api

    suspend fun fetchPost(id: Int) = api.fetchPost(id)
    suspend fun fetchPosts() = api.fetchPosts()
    suspend fun savePost(post: ApiPostData) = api.savePost(post)
    suspend fun searchPost(query: String) = api.searchPost(query)
}
