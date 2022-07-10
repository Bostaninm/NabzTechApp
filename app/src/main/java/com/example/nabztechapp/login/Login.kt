package com.example.nabztechapp.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import com.example.nabztechapp.common.Response

@Composable
fun LoginScreen(viewModel: LoginViewModel,navigateToMainScreen: () -> Unit) {

    val state by viewModel.loginScreenState.observeAsState()
    var username by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}

    Column(Modifier.fillMaxSize(1f), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        when(state) {
            is Response.Error -> {
                Text(
                    text = (state as Response.Error).message,
                    color = Color.Red
                )
            }
            is Response.Loading -> CircularProgressIndicator()
            is Response.Success -> {
                navigateToMainScreen()
            }
            else -> {}
        }

        TextField(value = username, onValueChange = {username = it}, placeholder = {Text("Username")}, modifier = Modifier.testTag("UsernameField"))
        TextField(value = password, onValueChange = {password = it},  placeholder = {Text("Password")})
        Button(onClick = { viewModel.login(username, password) }) {
            Text("Login")
        }
    }
}




