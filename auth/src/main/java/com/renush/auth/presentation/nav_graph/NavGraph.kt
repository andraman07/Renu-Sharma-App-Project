package com.renush.auth.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.renush.auth.presentation.screens.OpenAppScreen
import com.renush.auth.presentation.screens.RegisterScreen
import com.renush.auth.presentation.screens.SignInScreen

@Composable
fun NavGraph() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.OpenAppScreen.route) {
        composable(Routes.OpenAppScreen.route) {
            OpenAppScreen(navController)
        }
        composable(Routes.LoginScreen.route) {
            SignInScreen(navController)
        }
        composable(Routes.SignupScreen.route) {
            RegisterScreen(navController)
        }
//        composable(Routes.CreatePassScreen.route) {
//            CreatePasswordScreen()
//        }
//        composable(Routes.ProfileDetailsScreen.route) {
//            ProfileDetailsScreen()
//        }
//        composable(Routes.InternshipDetailsScreen.route) {
//            InternshipDetailsScreen()
//        }
    }
}