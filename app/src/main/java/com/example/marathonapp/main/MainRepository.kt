package com.example.marathonapp.main

import javax.inject.Inject


class MainRepository @Inject constructor(private val MainAPI: MainAPI) : IMainRepository {
    override suspend fun checkConnectionHealth(): String {
       return MainAPI.getHealthJwtToken()
    }
}