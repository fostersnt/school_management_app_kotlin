package com.loan_app.data.repository

import com.loan_app.data.model.Post
import com.loan_app.data.model.PostPostData
import com.loan_app.data.network.RetrofitInstance

class PostRepository {
    private val api = RetrofitInstance.api

    suspend fun getUser(id: Int) = api.getPostData(id)
    suspend fun getUsers() = api.getPosts()
    suspend fun postUser(post: PostPostData) = api.savePostData(post)
    suspend fun searchUsers(query: String) = api.searchPost(query)
}