package com.example.nabztechapp.login

import com.example.nabztechapp.common.ISharedPreferenceApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginRepositoryTest {

    @Mock
    lateinit var mockedAuthApi : AuthenticationAPI

    @Mock
    lateinit var mockedSharedPreference : ISharedPreferenceApi

    lateinit var loginRepository : LoginRepository

    @Before
    fun setUp() {
        loginRepository = LoginRepository(mockedSharedPreference ,mockedAuthApi)

    }

    @ExperimentalCoroutinesApi
    @Test
    fun is_login_working() = runBlocking {

        Mockito.`when`(mockedAuthApi.login(UserLoginDTO("username","password"))).thenReturn("FakeToken")
        // Mockito.`when`(mockedSharedPreference.getString(Constants.TOKEN_KEY, null)).thenReturn(null)

        val responseList = loginRepository.login("username", "password").toList()
        verify(mockedAuthApi).login(UserLoginDTO("username","password"))
        verify(mockedSharedPreference).setToken("FakeToken")


        assert(responseList[0] is Response.Loading)
        assert(responseList[1] is Response.Success)
        val sr = responseList[1] as Response.Success
        assert(sr.data == "FakeToken")

    }
}
