package com.example.changeapp.login

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginScreen {
    @get: Rule
    val composeRuleTest = createComposeRule()

    @Before
    fun init() {
        composeRuleTest.setContent {

        }
    }

    @Test
    fun isLoginButtonWorking() {
        composeRuleTest.onNodeWithText("Username").performTextInput("string1")
        composeRuleTest.onNodeWithText("Password").performTextInput("string2")
        composeRuleTest.onNodeWithText("Login").onParent().performClick()
    }
}