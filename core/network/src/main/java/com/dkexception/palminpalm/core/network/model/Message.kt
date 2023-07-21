package com.dkexception.palminpalm.core.network.model

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("content")
    val content: String? = null
)
