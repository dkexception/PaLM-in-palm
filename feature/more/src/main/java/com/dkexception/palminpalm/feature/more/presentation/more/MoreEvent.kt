package com.dkexception.palminpalm.feature.more.presentation.more

sealed class MoreEvent {

    object OnGoToModelsListClicked : MoreEvent()

    object OnOpenStandaloneChatClicked : MoreEvent()
}
