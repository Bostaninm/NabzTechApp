package com.example.changeapp.net.api

import com.example.changeapp.profile.UserProfileDto
import retrofit2.http.GET


interface ProfileAPI {

    @GET("api/User/Profile")
    suspend fun getUserProfile() : UserProfileDto
}