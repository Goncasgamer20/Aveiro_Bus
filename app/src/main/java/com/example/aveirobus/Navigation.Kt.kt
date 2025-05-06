package com.example.aveirobus

import androidx.compose.foundation.layout.PaddingValues // Import PaddingValues
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
    paddingValues: PaddingValues // Added this parameter
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Autocarros.route
        // No need to apply padding here if applying to individual screens
    ) {
        composable(BottomNavItem.Autocarros.route) {
            // Pass paddingValues to Autocarros if it uses Scaffold padding
            Autocarros(paddingValues = paddingValues)
        }
        composable(BottomNavItem.Avisos.route) {
            // Pass paddingValues to Avisos if it uses Scaffold padding
            Avisos(paddingValues = paddingValues)
        }
        composable(BottomNavItem.AiChat.route) {
            // Pass paddingValues to AiChat
            AiChat(paddingValues = paddingValues)
        }
        composable(BottomNavItem.Carteira.route) {
            // Pass paddingValues to Carteira if it uses Scaffold padding
            Carteira(paddingValues = paddingValues)
        }
        composable(BottomNavItem.Opcoes.route) {
            // Pass paddingValues to Opcoes if it uses Scaffold padding
            Opcoes(paddingValues = paddingValues)
        }
        composable(TopNavItem.LoginScreen.route) {
            // Login screen likely doesn't need Scaffold padding if it's full screen
            LoginScreen(onLoginSuccess, onLoginFailure)
        }
        composable("userProfile") {
            // Pass paddingValues to UserProfileScreen if it uses Scaffold padding
            UserProfileScreen(onLogout, paddingValues = paddingValues)
        }
    }
}