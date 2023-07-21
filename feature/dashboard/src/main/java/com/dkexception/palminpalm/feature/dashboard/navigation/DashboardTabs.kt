package com.dkexception.palminpalm.feature.dashboard.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.ui.graphics.vector.ImageVector
import com.dkexception.palminpalm.feature.chat.presentation.ChatRoute
import com.dkexception.palminpalm.feature.more.MoreRootRoute

sealed class DashboardTabs(
    val route: String,
    val icon: ImageVector,
    val title: String
) {

    object CHAT : DashboardTabs(
        route = ChatRoute.route,
        icon = Icons.Outlined.Chat,
        title = "Chat"
    )

    object MORE : DashboardTabs(
        route = MoreRootRoute.route,
        icon = Icons.Outlined.Menu,
        title = "More"
    )
}