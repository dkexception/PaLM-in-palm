package com.dkexception.palminpalm.feature.chat.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dkexception.palminpalm.feature.chat.data.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ChatState())
    val state = _state.asStateFlow()

    fun onEvent(event: ChatEvent) {
        when (event) {
            is ChatEvent.OnPromptChange -> {
                _state.update { it.copy(chatPrompt = event.newPrompt) }
            }

            ChatEvent.OnPromptSubmit -> state.value.chatPrompt.takeUnless(String::isBlank)?.let {
                submitPrompt()
            }
        }
    }

    private fun submitPrompt() = viewModelScope.launch {

        val prompt = state.value.chatPrompt.trim()

        _state.update { state ->
            state.copy(
                chatPrompt = "",
                isLoading = true,
                chatList = state.chatList.toMutableList().apply {
                    add(
                        ChatModel(
                            textOrUrl = prompt,
                            userType = ChatUserType.USER
                        )
                    )
                    add(ChatModel.getLoadingItem())
                }.toList()
            )
        }

        val palmResponseModel: ChatModel = repository.generateMessage(state.value.chatList)

        _state.update { state ->
            state.copy(
                isLoading = false,
                chatList = state.chatList
                    .filter { it.chatType != ChatType.LOADING }
                    .toMutableList()
                    .apply {
                        add(palmResponseModel)
                    }.toList()
            )
        }
    }
}
