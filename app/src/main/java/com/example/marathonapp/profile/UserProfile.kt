package com.example.marathonapp.profile

import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class UserProfile(@Json(name = "id") val id : String,
                       @Json(name = "firstName")val firstName: String,
                       @Json(name = "lastName") val lastName: String,
                       @Json(name = "groupId") val groupId: String)
