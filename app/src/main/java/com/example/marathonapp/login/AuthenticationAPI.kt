package com.example.marathonapp.login

import com.example.marathonapp.login.UserLoginDTO
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationAPI {
    @POST("api/authentication/login")
    suspend fun login(@Body user : UserLoginDTO) : String

    @POST("api/authentication/signIn")
    suspend fun signIn(@Body user: UserLoginDTO)

    @POST("api/authentication/validation")
    suspend fun validate(@Body token: String) : String
}