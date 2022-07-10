package com.example.marathonapp.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class ProfileScreenUiState(
    val loading: Boolean = false,

    val error: Boolean = false,
    val errorMessage: String = "",

    val success: Boolean = false,
    val firstName: String = "",
    val lastName: String = "",
    val groupId: String = "",
)

@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {
    val uiState by viewModel.profileScreenState.observeAsState(ProfileScreenUiState())
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        when {
            uiState.loading -> {
                CircularProgressIndicator()
            }
            uiState.error -> {
                Text(uiState.errorMessage, color = MaterialTheme.colors.error)
            }
            uiState.success -> {
                Icon(Icons.Default.Person, "UserProfileIcon", modifier = Modifier.size(64.dp))
                Spacer(modifier = Modifier.height(16.dp))
                Text("${uiState.firstName} ${uiState.lastName}")
                Spacer(modifier = Modifier.height(16.dp))
                Text(uiState.groupId)
            }
        }

    }

}

