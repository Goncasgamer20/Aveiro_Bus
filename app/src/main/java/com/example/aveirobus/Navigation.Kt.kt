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
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Autocarros.route) {
        composable(BottomNavItem.Autocarros.route) {
            ScreenContent(name = "Autocarros")
        }
        composable(BottomNavItem.Avisos.route) {
            ScreenContent(name = "Avisos")
        }
        composable(BottomNavItem.AiChat.route) {
            ScreenContent(name = "Ai Chat")
        }
        composable(BottomNavItem.Carteira.route) {
            ScreenContent(name = "Carteira")
        }
        composable(BottomNavItem.Opcoes.route) {
            ScreenContent(name = "Opções")
        }
    }
}

@Composable
fun ScreenContent(name: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = name)
    }
}