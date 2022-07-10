package com.example.changeapp.common

import com.example.changeapp.profile.UserProfile

interface ISharedPreferenceApi {
    fun getToken():String?
    fun setToken(token: String)

    fun getUserProfile():UserProfile?
    fun setUserProfile(userProfile: UserProfile)
}