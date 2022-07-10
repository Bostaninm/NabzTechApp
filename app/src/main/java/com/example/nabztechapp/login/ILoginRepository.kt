package com.example.nabztechapp.login

import com.example.nabztechapp.common.Response
import kotlinx.coroutines.flow.Flow

interface ILoginRepository {
    fun login(username : String, password: String) : Flow<Response<String>>
    fun getAccessToken() : String?
    fun setAccessToken(token : String)
}
