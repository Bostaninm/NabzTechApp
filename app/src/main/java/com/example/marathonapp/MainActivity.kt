package com.example.marathonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.marathonapp.common.NavigationRoutes
import com.example.marathonapp.login.LoginScreen
import com.example.marathonapp.login.LoginViewModel
import com.example.marathonapp.main.MainScreen
import com.example.marathonapp.main.MainViewModel
import com.example.marathonapp.profile.ProfileScreen
import com.example.marathonapp.profile.ProfileViewModel
import com.example.marathonapp.ui.theme.MarathonAppTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.rememberNavController as rememberNavController

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<InitViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            MarathonAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(navController = navController,
                        startDestination = mainViewModel.initialScreen.route) {
                        composable(NavigationRoutes.LoginScreen.route) {
                            LoginScreen(
                                hiltViewModel<LoginViewModel>()) {
                                navController.navigate(NavigationRoutes.MainScreen.route)
                            }
                        }
                        composable(NavigationRoutes.MainScreen.route) {
                            MainScreen(
                                hiltViewModel<MainViewModel>(),
                                navigateToProfileScreen = { navController.navigate(NavigationRoutes.ProfileScreen.route) }
                            )
                        }
                        composable(NavigationRoutes.ProfileScreen.route) {
                            ProfileScreen(hiltViewModel<ProfileViewModel>())
                        }
                    }

                }
            }
        }
    }


}

