package com.example.nabztechapp.net.api

import com.example.nabztechapp.profile.UserProfileDto
import retrofit2.http.GET


interface ProfileAPI {

    @GET("api/User/Profile")
    suspend fun getUserProfile() : UserProfileDto
}