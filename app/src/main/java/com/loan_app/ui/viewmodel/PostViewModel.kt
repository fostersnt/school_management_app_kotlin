package com.loan_app.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loan_app.data.model.Post
import com.loan_app.data.model.ApiPostData
import com.loan_app.data.local.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel (private val repository: PostRepository) : ViewModel() {
    val searchResults = MutableLiveData<List<Post>>()
//    val searchResults: LiveData<List<Post>> = _searchResults

        var post =  MutableLiveData<Post>(null)
        var posts = MutableLiveData<List<Post>>(emptyList())
//        var searchResults  = MutableLiveData<List<Post>>(emptyList())

        fun fetchPost(id: Int) {
            viewModelScope.launch {
                val response = repository.fetchPost(id)
                if (response.isSuccessful) {
                    post.value = response.body()
                }
            }
        }

        fun fetchPosts() {
            viewModelScope.launch {
                val response = repository.fetchPosts()
                if (response.isSuccessful) {
                    posts.value = response.body() ?: emptyList()
                }
            }
        }

        fun createPost(url: String, title: String, content: String) {
            viewModelScope.launch {
                val response = repository.savePost(ApiPostData(url, title, content))
                if (response.isSuccessful) {
                    fetchPosts()  // Refresh list
                }
            }
        }

        fun searchPost(query: String) {
            viewModelScope.launch {
                val response = repository.searchPost(query)
                if (response.isSuccessful) {
                    searchResults.postValue(response.body());// = response.body() ?: emptyList()
                }
            }
        }
}