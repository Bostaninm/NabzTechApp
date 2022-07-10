package com.example.nabztechapp.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nabztechapp.login.ILoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: IMainRepository, private val loginRepository: ILoginRepository) : ViewModel(){
    private val _uiState = mutableStateOf("")
    val uiState : State<String> = _uiState

    fun checkHealth() {
        viewModelScope.launch {
            _uiState.value = repository.checkConnectionHealth()
        }

    }

    fun getToken(): String {
       return loginRepository.getAccessToken() ?: "Empty"
    }

}