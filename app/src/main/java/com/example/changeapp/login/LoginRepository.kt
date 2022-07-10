package com.example.changeapp.login

import com.example.changeapp.common.ISharedPreferenceApi
import com.example.changeapp.common.Response
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val sharedPreferenceApi: ISharedPreferenceApi,
    private val authenticationAPI: AuthenticationAPI
) : ILoginRepository {
    var token : String? = null

    override fun login(username: String, password: String) = flow<Response<String>> {
        emit(Response.Loading())
        try {
            val token = authenticationAPI.login(UserLoginDTO(username, password))
            if (token.isNotEmpty()) {
                setAccessToken(token)
                emit(Response.Success(token))
            } else {
                emit(Response.Error("Empty token returned!"))
            }
        } catch (e: HttpException) {
            emit(Response.Error(e.message()))
        } catch (e: IOException) {
            emit(Response.Error(e.localizedMessage ?: "Unknown Error"))
        }
    }

    override fun getAccessToken(): String? {
        if(token == null)
            token = sharedPreferenceApi.getToken()
        return token
    }

    override fun setAccessToken(token : String) {
        sharedPreferenceApi.setToken(token)
    }
}