package com.dkexception.palminpalm.core.network.model

import com.google.gson.annotations.SerializedName

data class GenerateMessageRequest(
    @SerializedName("prompt")
    val prompt: Prompt? = null,
    @SerializedName("temperature")
    val temperature: Double? = null
)

data class Prompt(
    @SerializedName("messages")
    val messages: List<Message>? = null
)

