package com.example.marathonapp.main

interface IMainRepository {
    suspend fun checkConnectionHealth() : String
}