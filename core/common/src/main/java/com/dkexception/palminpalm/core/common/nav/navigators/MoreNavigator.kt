package com.dkexception.palminpalm.core.common.nav.navigators

import androidx.activity.ComponentActivity

interface MoreNavigator {

    fun goToModelsScreen()

    fun openStandaloneChatScreen(activity: Class<*>)
}
