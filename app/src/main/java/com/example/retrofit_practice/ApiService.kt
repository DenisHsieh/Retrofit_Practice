package com.example.retrofit_practice

import com.example.retrofit_practice.model.*
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getPosts(): Call<List<Posts>>

    @GET("/comments")
    fun getComments(): Call<List<Comments>>

    @GET("/albums")
    fun getAlbums(): Call<List<Albums>>

    @GET("/photos")
    fun getPhotos(): Call<List<Photos>>

    @GET("/todos")
    fun getTodos(): Call<List<Todos>>

    @GET("/users")
    fun getUsers(): Call<List<Users>>
}