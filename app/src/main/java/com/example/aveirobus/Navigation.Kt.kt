package com.example.aveirobus

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(
    navController: NavHostController,
    isLoggedIn: Boolean,
    onLoginSuccess: () -> Unit,
    onLoginFailure: () -> Unit,
    onLogout: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Autocarros.route
    ) {
        composable(BottomNavItem.Autocarros.route) {
            Autocarros()
        }
        composable(BottomNavItem.Avisos.route) {
            Avisos()
        }
        composable(BottomNavItem.AiChat.route) {
            AiChat()
        }
        composable(BottomNavItem.Carteira.route) {
            Carteira()
        }
        composable(BottomNavItem.Opcoes.route) {
            Opcoes()
        }
        composable("login") {
            LoginScreen(onLoginSuccess = onLoginSuccess, onLoginFailure = onLoginFailure)
        }
        composable("register") {
            RegisterScreen()
        }
        composable("userProfile") {
            UserProfileScreen(onLogout = onLogout)
        }
    }
}