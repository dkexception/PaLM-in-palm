package com.dkexception.palminpalm.feature.more.presentation.models_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.dkexception.palminpalm.feature.more.MoreNestedRoute

object PaLMModelsRoute {

    val route = MoreNestedRoute.MODELS_LIST.route

    @Composable
    fun Content() {

        val viewModel: PaLMModelsViewModel = hiltViewModel()
        val state: PaLMModelsState by viewModel.state.collectAsState()
        PaLMModelsScreen(state, viewModel::onEvent)
    }
}
