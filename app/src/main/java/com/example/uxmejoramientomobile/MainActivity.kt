package com.example.uxmejoramientomobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.uxmejoramientomobile.navigation.AppNavGraph
import com.example.uxmejoramientomobile.ui.theme.UXMejoramientoMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UXMejoramientoMobileTheme {
                val navController = rememberNavController()
                AppNavGraph(navController)
            }
        }
    }
}
