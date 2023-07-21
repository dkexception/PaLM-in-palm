package com.dkexception.palminpalm.feature.chat.presentation

import com.dkexception.palminpalm.feature.chat.presentation.ChatModel.Companion.getChatStart

data class ChatState(

    val chatPrompt: String = "",
    val isLoading: Boolean = false,
    val chatList: List<ChatModel> = getChatStart()
)

data class ChatModel(

    val textOrUrl: String,
    val userType: ChatUserType,
    val chatType: ChatType = ChatType.TEXT
) {

    companion object {

        fun getLoadingItem() = ChatModel(
            textOrUrl = "...",
            userType = ChatUserType.PALM,
            chatType = ChatType.LOADING
        )

        fun getChatStart() = listOf(
            ChatModel("Hello, how may I help you today?", ChatUserType.PALM)
        )

        fun getDummyChatListForUIPreview() = listOf(
            ChatModel("Hello, how may I help you today?", ChatUserType.PALM),
            ChatModel("Hi.. wanted to discuss something", ChatUserType.USER)
        )
    }
}

enum class ChatType {

    LOADING,

    TEXT,

    IMAGE
}

enum class ChatUserType {

    PALM,

    USER
}
