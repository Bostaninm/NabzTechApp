package com.example.marathonapp.profile

import com.squareup.moshi.Json


data class UserProfileDto(@Json(name = "id") val id : String?,
                       @Json(name = "firstName")val firstName: String?,
                       @Json(name = "lastName") val lastName: String?,
                       @Json(name = "groupId") val groupId: String?) {

    fun toUserProfile(): UserProfile {
        return UserProfile(
            id = this.id ?: "",
            firstName = this.firstName ?: "",
            lastName = this.lastName ?: "",
            groupId = this.groupId ?: ""
        )
    }
}