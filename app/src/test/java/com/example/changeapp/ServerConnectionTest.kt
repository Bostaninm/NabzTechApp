package com.example.changeapp

import com.example.changeapp.login.UserLoginDTO
import com.example.changeapp.login.AuthenticationAPI
import com.example.changeapp.main.MainAPI
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ServerConnectionTest {

    val service = Retrofit.Builder().baseUrl(BuildConfig.API_ENDPOINT)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create()).build()


    @Test
    fun isConnectionHealthy() {
        runBlocking {
            val healthApi = service.create(MainAPI::class.java)
            assertEquals(healthApi.getHealthSimple(), "Healthy")
        }
    }

    @Test
    fun isAuthenticationWorking() = runBlocking {
        val authenticationAPI = service.create(AuthenticationAPI::class.java)
        val user = UserLoginDTO("mahdi", "123")
        authenticationAPI.signIn(user)
        val token = authenticationAPI.login(user)
        print(token)
        assert(token.isNotEmpty())
    }

    @Test
    fun isJwtBearerWorking() = runBlocking {

        val authenticationAPI = service.create(AuthenticationAPI::class.java)
        val user = UserLoginDTO("mahdi", "123")
        authenticationAPI.signIn(user)
        val token = authenticationAPI.login(user)

        val authHeader= "Bearer $token"
        val okHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val newReq = chain.request().newBuilder().header("Authorization", authHeader).build()
            return@addInterceptor chain.proceed(newReq)
        }


        val serviceWithAuthHeader = Retrofit.Builder().baseUrl(BuildConfig.API_ENDPOINT).client(okHttpClient.build())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create()).build()

        val authHealthAPI = serviceWithAuthHeader.create(MainAPI::class.java)
        assertEquals(authHealthAPI.getHealthJwtToken(), "Healthy")
    }

}