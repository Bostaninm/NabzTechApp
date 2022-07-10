package com.example.changeapp.main

interface IMainRepository {
    suspend fun checkConnectionHealth() : String
}