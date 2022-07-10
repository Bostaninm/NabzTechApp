package com.example.changeapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.changeapp.login.LoginViewModel
import com.example.changeapp.login.ILoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify

@ExperimentalCoroutinesApi
class LoginTest {

    @Mock
    lateinit var mockedRepo : ILoginRepository

    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var instantExcutionRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }


    @After
    fun cleanUp() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }


    @Test
    fun givenCorrectInput_whenLogin_shouldCallRepositoryLogin() = runBlocking {

        val viewModel = LoginViewModel(mockedRepo)
        viewModel.login("username","password")
        verify(mockedRepo.login("username","password"))

    }
}

