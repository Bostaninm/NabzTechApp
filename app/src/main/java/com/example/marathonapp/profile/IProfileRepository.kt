package com.example.marathonapp.profile

import com.example.marathonapp.common.Response
import kotlinx.coroutines.flow.Flow

interface IProfileRepository {
    suspend fun getUserProfile() : Flow<Response<UserProfile>>
}