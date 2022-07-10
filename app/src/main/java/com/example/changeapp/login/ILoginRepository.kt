package com.example.changeapp.login

import com.example.changeapp.common.Response
import kotlinx.coroutines.flow.Flow

interface ILoginRepository {
    fun login(username : String, password: String) : Flow<Response<String>>
    fun getAccessToken() : String?
    fun setAccessToken(token : String)
}
