package com.example.changeapp

import androidx.lifecycle.ViewModel
import com.example.changeapp.common.NavigationRoutes
import com.example.changeapp.login.ILoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InitViewModel @Inject constructor(private val repository: ILoginRepository) : ViewModel() {
    var initialScreen = NavigationRoutes.LoginScreen
    init {
        if(repository.getAccessToken() != null) {
            initialScreen = NavigationRoutes.MainScreen
        }
    }
}
