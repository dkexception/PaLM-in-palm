package com.dkexception.palminpalm.core.common.nav

import android.content.Intent
import androidx.navigation.NavHostController
import com.dkexception.palminpalm.core.common.nav.navigators.MoreNavigator

class DashboardNavigator : MoreNavigator {

    private var navController: NavHostController? = null

    fun bind(navController: NavHostController) {
        this.navController = navController
    }

    override fun goToModelsScreen() {
        navController?.navigate(NavRoutes.MODELS_LIST.route)
    }

    override fun openStandaloneChatScreen(activity: Class<*>) {
        navController?.context?.let {
            it.startActivity(Intent(it, activity).apply {
                flags = Intent.FLAG_ACTIVITY_MULTIPLE_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }
}
