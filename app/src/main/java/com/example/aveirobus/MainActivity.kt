package com.example.aveirobus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.aveirobus.ui.theme.AveiroBusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AveiroBusTheme {
                var isLoggedIn by remember { mutableStateOf(false) } // State variable for login status
                val navController = rememberNavController() // Create a NavController

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        MyTopAppBar(
                            isLoggedIn = isLoggedIn,
                            onUserButtonClick = {
                                if (isLoggedIn) {
                                    navController.navigate("userProfile")
                                } else {
                                    navController.navigate("login")
                                }
                            },
                        )
                    },
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) { innerPadding ->
                    NavigationGraph(
                        navController = navController,
                        isLoggedIn = isLoggedIn,
                        onLoginSuccess = {
                            isLoggedIn = true
                            navController.popBackStack() // Remove the login screen from the back stack
                            navController.navigate(BottomNavItem.Autocarros.route)
                        },
                        onLogout = {
                            isLoggedIn = false
                            navController.popBackStack() // Remove the user profile screen from the back stack
                            navController.navigate(BottomNavItem.Autocarros.route)
                        }
                    )
                }
            }
        }
    }
}