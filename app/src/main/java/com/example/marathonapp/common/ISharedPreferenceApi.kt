package com.example.marathonapp.common

import com.example.marathonapp.profile.UserProfile

interface ISharedPreferenceApi {
    fun getToken():String?
    fun setToken(token: String)

    fun getUserProfile():UserProfile?
    fun setUserProfile(userProfile: UserProfile)
}