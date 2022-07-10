package com.example.marathonapp.common

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.marathonapp.profile.UserProfile

class SharedPreferenceApi(context: Context) : ISharedPreferenceApi {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)
    private var _token : String? = null

    override fun getToken(): String? {
        if(_token == null)
            _token = sharedPreferences.getString(Constants.TOKEN_KEY, null)
        return _token
    }

    override fun setToken(token: String) {
        sharedPreferences.edit {
            putString(Constants.TOKEN_KEY, token)
            apply()
        }
    }

    override fun getUserProfile(): UserProfile? {
        if(sharedPreferences.getBoolean(Constants.PROFILE_EXIST, false)) {
            return UserProfile(
                id = sharedPreferences.getString(Constants.USER_ID, "") ?: "",
                firstName = sharedPreferences.getString(Constants.FIRST_NAME, "")?: "",
                lastName = sharedPreferences.getString(Constants.LAST_NAME, "")?: "",
                groupId = sharedPreferences.getString(Constants.GROUP_ID, "")?: ""
            )
        }
        return null
    }

    override fun setUserProfile(userProfile: UserProfile) {
        sharedPreferences.edit {
            putBoolean(Constants.PROFILE_EXIST, true)
            putString(Constants.USER_ID, userProfile.id)
            putString(Constants.FIRST_NAME, userProfile.firstName)
            putString(Constants.LAST_NAME, userProfile.lastName)
            putString(Constants.GROUP_ID, userProfile.groupId)
            apply()
        }
    }
}