package com.dkexception.palminpalm.feature.chat.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.dkexception.palminpalm.core.common.nav.NavRoutes

object ChatRoute {

    val route = NavRoutes.CHAT.route

    @Composable
    fun Content() {

        val viewModel: ChatViewModel = hiltViewModel()
        val state: ChatState by viewModel.state.collectAsState()
        ChatScreen(state, viewModel::onEvent)
    }
}
