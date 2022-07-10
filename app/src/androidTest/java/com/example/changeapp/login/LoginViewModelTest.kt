package com.example.changeapp.login

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.changeapp.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginViewModelTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun isLoginButtonLeadToMainScreen() {

        composeTestRule.onNodeWithText("Username").performTextInput("string")
        composeTestRule.onNodeWithText("Password").performTextInput("string")
        composeTestRule.onNode(hasClickAction() and hasAnyChild(hasText("Login"))).performClick()

        composeTestRule.onNodeWithText("HomeScreen").assertIsDisplayed()
    }

}

