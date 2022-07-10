package com.example.marathonapp.net.api

import com.example.marathonapp.profile.UserProfile
import com.example.marathonapp.profile.UserProfileDto
import retrofit2.http.GET


interface ProfileAPI {

    @GET("api/User/Profile")
    suspend fun getUserProfile() : UserProfileDto
}