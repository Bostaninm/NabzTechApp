package com.example.changeapp.profile

import com.example.changeapp.common.Response
import kotlinx.coroutines.flow.Flow

interface IProfileRepository {
    suspend fun getUserProfile() : Flow<Response<UserProfile>>
}