package com.dkexception.palminpalm.feature.more.presentation.more

import androidx.lifecycle.ViewModel
import com.dkexception.palminpalm.core.common.nav.navigators.MoreNavigator
import com.dkexception.palminpalm.feature.chat.presentation.standalone.ChatActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoreViewModel @Inject constructor(
    private val moreNavigator: MoreNavigator
) : ViewModel() {

    fun onEvent(event: MoreEvent) {
        when (event) {
            MoreEvent.OnGoToModelsListClicked -> moreNavigator.goToModelsScreen()
            MoreEvent.OnOpenStandaloneChatClicked -> moreNavigator.openStandaloneChatScreen(
                ChatActivity::class.java
            )
        }
    }
}
