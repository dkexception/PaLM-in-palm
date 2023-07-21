package com.dkexception.palminpalm

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dkexception.palminpalm.feature.dashboard.DashboardRoute

@Composable
fun PaLMNavigationManager(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = DashboardRoute.route
    ) {

        composable(DashboardRoute.route) {
            DashboardRoute.Content()
        }
    }
}
