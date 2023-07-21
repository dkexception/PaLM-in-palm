package com.dkexception.palminpalm.feature.dashboard.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dkexception.palminpalm.feature.chat.presentation.ChatRoute
import com.dkexception.palminpalm.feature.more.MoreRootRoute.moreNavGraph

@Composable
internal fun DashboardNavGraph(
    modifier: Modifier,
    navHostController: NavHostController
) {

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = DashboardTabs.CHAT.route
    ) {

        composable(DashboardTabs.CHAT.route) {
            ChatRoute.Content()
        }

        moreNavGraph()
    }
}
