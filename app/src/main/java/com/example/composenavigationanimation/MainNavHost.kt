package com.example.composenavigationanimation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
@Composable
fun MainNavHost(navController: NavHostController) {
    AnimatedNavHost(navController = navController, startDestination = "first_screen") {
        composable(
            route = "first_screen",
            enterTransition = {
                when (initialState.destination.route) {
                    "second_screen" -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(800)
                    )
                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    "second_screen" -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(800)
                    )
                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    "second_screen" -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(800)
                    )
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    "second_screen" -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(800)
                    )
                    else -> null
                }
            }
        ) {
            FistScreen {
                navController.navigate("second_screen")
            }
        }
        composable(route = "second_screen",
            enterTransition = {
                when (initialState.destination.route) {
                    "first_screen" -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(800)
                    )
                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    "first_screen" -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(800)
                    )
                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    "first_screen" -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(800)
                    )
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    "first_screen" -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(800)
                    )
                    else -> null
                }
            }
        ) {
            SecondScreen {
                navController.popBackStack()
            }
        }
    }
}