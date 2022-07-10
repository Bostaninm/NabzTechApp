package com.example.nabztechapp.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

@Composable
fun MainScreen(viewModel: MainViewModel, navigateToProfileScreen: () -> Unit) {
    val state by viewModel.uiState
    Column() {
        Button(onClick = viewModel::checkHealth) {
            Text(viewModel.getToken())
        }
        Text(state)
        Button(onClick = navigateToProfileScreen) {
            Text(text = "Go To Profile Screen")
        }
    }


}