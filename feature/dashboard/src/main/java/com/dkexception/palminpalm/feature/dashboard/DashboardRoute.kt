package com.dkexception.palminpalm.feature.dashboard

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.dkexception.palminpalm.core.common.nav.NavRoutes

object DashboardRoute {

    val route = NavRoutes.DASHBOARD.route

    @Composable
    fun Content() {

        val viewModel: DashboardViewModel = hiltViewModel()
        DashboardScreen(viewModel::onEvent) {
            viewModel.dashboardNavigator.bind(it)
        }
    }
}
