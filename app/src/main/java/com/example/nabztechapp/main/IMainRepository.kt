package com.example.nabztechapp.main

interface IMainRepository {
    suspend fun checkConnectionHealth() : String
}