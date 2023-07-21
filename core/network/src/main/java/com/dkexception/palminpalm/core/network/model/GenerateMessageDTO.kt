package com.dkexception.palminpalm.core.network.model

import com.google.gson.annotations.SerializedName

data class GenerateMessageDTO(

    @SerializedName("candidates")
    val candidates: List<Candidate>? = null,
    @SerializedName("messages")
    val messages: List<Message>? = null,

    @SerializedName("error")
    val error: PaLMError? = null
)

data class Candidate(
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("content")
    val content: String? = null
)

