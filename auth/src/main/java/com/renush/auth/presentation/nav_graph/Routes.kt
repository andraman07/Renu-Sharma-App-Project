package com.renush.auth.presentation.nav_graph

sealed class Routes(val route: String) {
    object OpenAppScreen : Routes(route = "open_app_screen")
    object LoginScreen : Routes(route = "login_screen")
    object SignupScreen : Routes(route = "signup_screen")
//    object CreatePassScreen : Routes(route = "create_pass_screen")
//    object ProfileDetailsScreen : Routes(route = "profile_details_screen")
//    object InternshipDetailsScreen : Routes(route = "internship_details_screen")
}