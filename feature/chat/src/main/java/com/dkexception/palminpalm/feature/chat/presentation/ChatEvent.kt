package com.dkexception.palminpalm.feature.chat.presentation

sealed class ChatEvent {

    data class OnPromptChange(val newPrompt: String) : ChatEvent()

    object OnPromptSubmit : ChatEvent()
}
