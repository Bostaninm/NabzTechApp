package com.example.changeapp.profile

import com.squareup.moshi.Json

data class UserProfile(@Json(name = "id") val id : String,
                       @Json(name = "firstName")val firstName: String,
                       @Json(name = "lastName") val lastName: String,
                       @Json(name = "groupId") val groupId: String)
