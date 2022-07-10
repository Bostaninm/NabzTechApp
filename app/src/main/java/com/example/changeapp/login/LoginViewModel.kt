package com.example.changeapp.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.changeapp.common.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository : ILoginRepository): ViewModel() {

    private val _loginScreenState = MutableLiveData<Response<String>>(Response.Loading())
    val loginScreenState : LiveData<Response<String>> = _loginScreenState

    fun login(username: String, password: String) {
        try {
            repository.login(username, password).onEach { response ->
                _loginScreenState.postValue(response)
            }.launchIn(viewModelScope)
        } catch (e: Throwable) {
            throw (e)
        }

    }


}