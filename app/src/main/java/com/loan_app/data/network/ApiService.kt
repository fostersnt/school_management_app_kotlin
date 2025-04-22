package com.loan_app.data.network

import com.loan_app.data.model.Post
import com.loan_app.data.model.PostPostData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("posts/{id}")
    suspend fun getPostData(@Path("id") id: Int): Response<Post>

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @POST("posts")
    suspend fun savePostData(@Body user: PostPostData): Response<Post>

    @GET("posts/search")
    suspend fun searchPost(@Query("query") query: String): Response<List<Post>>
}
