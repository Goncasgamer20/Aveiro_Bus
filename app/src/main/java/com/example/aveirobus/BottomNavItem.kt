package com.example.aveirobus

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavItem("home", "Home", Icons.Filled.Home)
    object Lines : BottomNavItem("lines", "Lines", Icons.Filled.List)
    object Map : BottomNavItem("map", "Map", Icons.Filled.LocationOn)
    object About : BottomNavItem("about", "About", Icons.Filled.Info)
    object Settings : BottomNavItem("settings", "Settings", Icons.Filled.Settings)
}