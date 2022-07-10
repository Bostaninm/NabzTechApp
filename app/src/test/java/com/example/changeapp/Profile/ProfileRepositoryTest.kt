package com.example.changeapp.Profile

import com.example.changeapp.common.ISharedPreferenceApi

import com.example.changeapp.net.api.ProfileAPI
import com.example.changeapp.profile.IProfileRepository
import com.example.changeapp.profile.ProfileRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ProfileRepositoryTest {

    @Mock
    lateinit var sharedPreferenceApi: ISharedPreferenceApi

    @Mock
    lateinit var webApi: ProfileAPI

    lateinit var profileRepo: IProfileRepository

    @Before
    fun setup() {
        profileRepo = ProfileRepository(sharedPreferenceApi, webApi)
    }

    @Test
    fun whenCallGetUserProfile_shouldInvokeGetStringOnSharedPreferenceApi(): Unit = runBlocking {
        profileRepo.getUserProfile()
        verify(sharedPreferenceApi).getUserProfile()
    }

    @Test
    fun givenGetStringOnSharedPreferenceReturnNull_whenCallGetUserProfile_shouldInvokeWebApiGetUserProfile(): Unit = runBlocking {
        // Mockito.`when`(sharedPreferenceApi.getString(any(),null)).thenReturn(null)
        profileRepo.getUserProfile()
        verify(webApi).getUserProfile()
    }
//
//    @Test
//    fun givenWebApiGetUserProfileReturn_whenCallGetUserProfile_should
}

