package com.example.changeapp.main

import retrofit2.http.GET

interface MainAPI {
    @GET("api/Health/")
    suspend fun getHealthSimple() : String

    @GET("api/Health/Jwt")
    suspend fun getHealthJwtToken() : String
}