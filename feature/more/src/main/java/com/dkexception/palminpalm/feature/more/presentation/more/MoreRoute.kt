package com.dkexception.palminpalm.feature.more.presentation.more

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.dkexception.palminpalm.feature.more.MoreNestedRoute

object MoreRoute {

    val route = MoreNestedRoute.MORE.route

    @Composable
    internal fun Content() {

        val viewModel: MoreViewModel = hiltViewModel()
        MoreScreen(viewModel::onEvent)
    }
}
