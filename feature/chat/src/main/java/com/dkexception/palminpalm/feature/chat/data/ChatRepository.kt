package com.dkexception.palminpalm.feature.chat.data

import com.dkexception.palminpalm.core.common.di.StandardDispatchers
import com.dkexception.palminpalm.core.network.api.PaLMApi
import com.dkexception.palminpalm.core.network.model.GenerateMessageRequest
import com.dkexception.palminpalm.core.network.model.Prompt
import com.dkexception.palminpalm.feature.chat.domain.toRequestMessageList
import com.dkexception.palminpalm.feature.chat.presentation.ChatModel
import com.dkexception.palminpalm.feature.chat.presentation.ChatUserType
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRepository @Inject constructor(
    private val paLMApi: PaLMApi,
    private val standardDispatchers: StandardDispatchers
) {

    suspend fun generateMessage(currentChat: List<ChatModel>): ChatModel =
        withContext(standardDispatchers.io) {
            try {
                val palmResponse = paLMApi.generateMessage(
                    request = GenerateMessageRequest(
                        prompt = Prompt(
                            messages = currentChat.toRequestMessageList()
                        )
                    )
                )?.candidates?.getOrNull(0)?.content ?: error("Invalid backend response!")

                ChatModel(
                    textOrUrl = palmResponse,
                    userType = ChatUserType.PALM
                )
            } catch (e: Exception) {
                ChatModel(
                    textOrUrl = e.message ?: "Error!",
                    userType = ChatUserType.PALM
                )
            }
        }
}
