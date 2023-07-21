package com.dkexception.palminpalm.feature.dashboard.navigation

import androidx.navigation.NavController

class DashboardNavigator {

    private var navController: NavController? = null

    fun bind(navController: NavController) {
        this.navController = navController
    }


}