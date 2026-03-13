package com.example.uxmejoramientomobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uxmejoramientomobile.screens.AlarmaScreen
import com.example.uxmejoramientomobile.screens.ConfirmacionScreen
import com.example.uxmejoramientomobile.screens.CreacionCapsaScreen
import com.example.uxmejoramientomobile.screens.CreacionMagScreen
import com.example.uxmejoramientomobile.screens.CreacionOmeScreen
import com.example.uxmejoramientomobile.screens.Principal0ProdScreen
import com.example.uxmejoramientomobile.screens.Principal1ProdScreen
import com.example.uxmejoramientomobile.screens.Principal2ProdScreen
import com.example.uxmejoramientomobile.screens.PrincipalConRetraso1Screen
import com.example.uxmejoramientomobile.screens.PrincipalConRetraso2Screen
import com.example.uxmejoramientomobile.screens.PrincipalConRetraso3Screen
import com.example.uxmejoramientomobile.screens.PrincipalConRetrasoEsperaScreen
import com.example.uxmejoramientomobile.screens.PrincipalTomadaScreen
import com.example.uxmejoramientomobile.screens.PosponerScreen
import com.example.uxmejoramientomobile.screens.TomarScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "principal_retraso_1") {
        composable("principal_retraso_1") {
            PrincipalConRetraso1Screen(navController)
        }
        composable("principal_retraso_2") {
            PrincipalConRetraso2Screen(navController)
        }
        composable("principal_retraso_3") {
            PrincipalConRetraso3Screen(navController)
        }
        composable("principal_retraso_espera") {
            PrincipalConRetrasoEsperaScreen(navController)
        }
        composable("principal_tomada") {
            PrincipalTomadaScreen(navController)
        }
        composable("principal_2prod") {
            Principal2ProdScreen(navController)
        }
        composable("principal_1prod") {
            Principal1ProdScreen(navController)
        }
        composable("principal_0prod") {
            Principal0ProdScreen(navController)
        }
        composable("creacion_capsa") {
            CreacionCapsaScreen(navController)
        }
        composable("creacion_ome") {
            CreacionOmeScreen(navController)
        }
        composable("creacion_mag") {
            CreacionMagScreen(navController)
        }
        composable("tomar") {
            TomarScreen(navController)
        }
        composable("posponer") {
            PosponerScreen(navController)
        }
        composable("alarma") {
            AlarmaScreen(navController)
        }
        composable("confirmacion") {
            ConfirmacionScreen(navController)
        }
    }
}
