@file:OptIn(ExperimentalMaterial3Api::class)

package com.dkexception.palminpalm.feature.dashboard

import android.content.Intent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dkexception.palminpalm.feature.chat.presentation.standalone.ChatActivity
import com.dkexception.palminpalm.feature.dashboard.navigation.DashboardNavGraph
import com.dkexception.palminpalm.feature.dashboard.navigation.DashboardTabs

@Preview
@Composable
internal fun DashboardScreen(
    onEvent: ((DashboardEvent) -> Unit)? = null,
    updateNavController: ((NavHostController) -> Unit)? = null
) {

    val bottomTabsController: NavHostController = rememberNavController()
    updateNavController?.invoke(bottomTabsController)

    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(bottomTabsController) },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { paddingValues ->

        Surface(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            DashboardNavGraph(
                modifier = Modifier.fillMaxSize(),
                navHostController = bottomTabsController,
//                onLaunchChatClicked = {
//                    context.startActivity(Intent(context, ChatActivity::class.java).apply {
//                        flags =
//                            Intent.FLAG_ACTIVITY_MULTIPLE_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
//                    })
//                }
            )
        }
    }
}

@Composable
private fun BottomNavigationBar(bottomTabsController: NavHostController) {

    val screens = listOf(DashboardTabs.CHAT, DashboardTabs.MORE)
    val navBackStackEntry by bottomTabsController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.White,
        tonalElevation = 4.dp
    ) {
        screens.forEach { screen ->

            val isSelected = currentDestination
                ?.hierarchy
                ?.any { it.route == screen.route } == true

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        bottomTabsController.navigate(screen.route) {
                            popUpTo(bottomTabsController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.title,
                        modifier = Modifier.scale(if (isSelected) 1.1f else 1f)
                    )
                },
                label = {
                    Text(
                        text = screen.title,
                        maxLines = 1,
                        fontSize = if (isSelected) 14.sp else 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    }
}
