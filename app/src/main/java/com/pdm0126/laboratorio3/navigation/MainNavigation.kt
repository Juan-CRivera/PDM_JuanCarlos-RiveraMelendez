package com.pdm0126.laboratorio3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdm0126.laboratorio3.screens.Home
import com.pdm0126.laboratorio3.screens.Lista
import com.pdm0126.laboratorio3.screens.Sensor

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            Home(
                navigateToLista = { navController.navigate(Lista) },
                navigateToSensor   = { navController.navigate(Sensor) }
            )
        }
        composable<Lista> {
            Lista(
                navigateBack = { navController.popBackStack() }
            )
        }
        composable<Sensor> {
            Sensor(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}