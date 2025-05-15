package com.school_management_app.data.network

import com.school_management_app.data.model.Post
import com.school_management_app.data.model.ApiPostData
import com.school_management_app.data.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    //------------------------------------- POST ACTIONS -------------------------------------------------
    @GET("posts/{id}")
    suspend fun fetchPost(@Path("id") id: Int): Response<Post>

    @GET("posts")
    suspend fun fetchPosts(): Response<List<Post>>

    @POST("posts")
    suspend fun savePost(@Body user: ApiPostData): Response<Post>

    @GET("posts/search")
    suspend fun searchPost(@Query("query") query: String): Response<List<Post>>

    //------------------------------------- USER ACTIONS -------------------------------------------------
    @GET("users/{id}")
    suspend fun fetchUser(@Path("id") id: Int): Response<User>

    @GET("users")
    suspend fun fetchUsers(): Response<List<User>>

    @POST("users")
    suspend fun saveUser(@Body user: ApiPostData): Response<User>

    @GET("users/search")
    suspend fun searchUser(@Query("query") query: String): Response<List<User>>
}
