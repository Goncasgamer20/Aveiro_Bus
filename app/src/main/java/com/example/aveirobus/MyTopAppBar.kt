package com.example.aveirobus

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    isLoggedIn: Boolean,
    onUserButtonClick: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = {
            // Remove the Text composable
        },
        navigationIcon = {
            IconButton(onClick = onUserButtonClick) {
                if (isLoggedIn) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle, // Logged-in icon
                        contentDescription = "User Profile"
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.Person, // Logged-out icon
                        contentDescription = "Login"
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent,
            navigationIconContentColor = Color.Black,
            actionIconContentColor = Color.Black
        )
    )
}

@Preview
@Composable
fun MyTopAppBarPreview() {
    MyTopAppBar(isLoggedIn = false, onUserButtonClick = {})
}