package com.dkexception.palminpalm.feature.chat.domain

import com.dkexception.palminpalm.core.network.model.Message
import com.dkexception.palminpalm.feature.chat.presentation.ChatModel
import com.dkexception.palminpalm.feature.chat.presentation.ChatType
import com.dkexception.palminpalm.feature.chat.presentation.ChatUserType

fun List<ChatModel>.toRequestMessageList(): List<Message> = this
    .filter { it.chatType != ChatType.LOADING }
    .map {
        Message(
            author = when (it.userType) {
                ChatUserType.PALM -> "palm"
                ChatUserType.USER -> "user"
            },
            content = it.textOrUrl
        )
    }
