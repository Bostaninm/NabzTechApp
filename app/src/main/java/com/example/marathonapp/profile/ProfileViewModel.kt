package com.example.marathonapp.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marathonapp.common.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(private val profileRepository: IProfileRepository): ViewModel() {
    private val _profileScreenState = MutableLiveData(ProfileScreenUiState())
    val profileScreenState: LiveData<ProfileScreenUiState> = _profileScreenState

    init {
        viewModelScope.launch {
            profileRepository.getUserProfile().collect {
                when(it) {
                    is Response.Error -> {
                        _profileScreenState.postValue(ProfileScreenUiState(error = true, errorMessage = it.message))
                    }
                    is Response.Loading -> {
                        _profileScreenState.postValue(ProfileScreenUiState(loading = true))
                    }
                    is Response.Success -> {
                        _profileScreenState.postValue(ProfileScreenUiState(success = true,
                        firstName = it.data.firstName,
                        lastName = it.data.lastName,
                        groupId = it.data.groupId))
                    }
                }
            }

        }
    }
}