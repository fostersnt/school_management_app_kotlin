package com.loan_app.data.repository

import com.loan_app.data.model.Post
import com.loan_app.data.model.PostPostData
import com.loan_app.data.network.RetrofitInstance

class PostRepository {
    private val api = RetrofitInstance.api

    suspend fun getPost(id: Int) = api.getPostData(id)
    suspend fun getPosts() = api.getPosts()
    suspend fun savePostData(post: PostPostData) = api.savePostData(post)
    suspend fun searchPost(query: String) = api.searchPost(query)
}