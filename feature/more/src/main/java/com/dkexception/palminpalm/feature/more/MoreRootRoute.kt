package com.dkexception.palminpalm.feature.more

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.dkexception.palminpalm.core.common.nav.NavRoutes
import com.dkexception.palminpalm.feature.more.presentation.models_list.PaLMModelsRoute
import com.dkexception.palminpalm.feature.more.presentation.more.MoreRoute

object MoreRootRoute {

    val route = NavRoutes.MORE_ROOT.route

    fun NavGraphBuilder.moreNavGraph() = navigation(
        route = MoreRootRoute.route,
        startDestination = MoreNestedRoute.MORE.route
    ) {

        composable(
            route = MoreRoute.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "dkexception.com/palm/more"
                }
            )
        ) {
            MoreRoute.Content()
        }

        composable(PaLMModelsRoute.route) {
            PaLMModelsRoute.Content()
        }
    }
}
