package com.example.aveirobus

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Warning

sealed class BottomNavItem(val route: String, val title: String, val icon: Any) {
    object Autocarros : BottomNavItem("autocarros", "Autocarros", R.drawable.bus)
    object Avisos : BottomNavItem("avisos", "Avisos", Icons.Filled.Warning)
    object AiChat : BottomNavItem("aichat", "Ai Chat", R.drawable.message)
    object Carteira : BottomNavItem("carteira", "Carteira", R.drawable.wallet)
    object Opcoes : BottomNavItem("opcoes", "Opções", Icons.Filled.Menu)
}