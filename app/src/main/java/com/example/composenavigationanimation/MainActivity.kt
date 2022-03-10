package com.example.composenavigationanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.example.composenavigationanimation.ui.theme.ComposeNavigationAnimationTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationAnimationTheme {
                val navController = rememberAnimatedNavController()
                MainNavHost(navController = navController)
            }
        }
    }
}