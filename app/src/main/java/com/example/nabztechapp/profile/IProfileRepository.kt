package com.example.nabztechapp.profile

import com.example.nabztechapp.common.Response
import kotlinx.coroutines.flow.Flow

interface IProfileRepository {
    suspend fun getUserProfile() : Flow<Response<UserProfile>>
}