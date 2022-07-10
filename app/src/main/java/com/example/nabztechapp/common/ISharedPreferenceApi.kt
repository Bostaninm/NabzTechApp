package com.example.nabztechapp.common

import com.example.nabztechapp.profile.UserProfile

interface ISharedPreferenceApi {
    fun getToken():String?
    fun setToken(token: String)

    fun getUserProfile():UserProfile?
    fun setUserProfile(userProfile: UserProfile)
}