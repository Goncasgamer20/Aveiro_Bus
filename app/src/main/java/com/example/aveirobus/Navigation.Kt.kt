package com.example.aveirobus

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(
    navController: NavHostController,
    isLoggedIn: Boolean,
    onLoginSuccess: () -> Unit,
    onLogout: () -> Unit
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
            LoginScreen(onLoginSuccess = onLoginSuccess)
        }
        composable("userProfile") {
            UserProfileScreen(onLogout = onLogout)
        }
    }
}

@Composable
fun ScreenContent(name: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = name)
    }
}