package com.dkexception.palminpalm.core.network.model

import com.google.gson.annotations.SerializedName

data class PaLMError(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: String? = null
)
