package com.dkexception.palminpalm.core.network.model

import com.google.gson.annotations.SerializedName

data class GetAllModelsListDTO(

    @SerializedName("models")
    val models: List<Model>? = null,

    @SerializedName("error")
    val error: PaLMError? = null
)

data class Model(
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("displayName")
    val displayName: String? = null,
    @SerializedName("inputTokenLimit")
    val inputTokenLimit: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("outputTokenLimit")
    val outputTokenLimit: Int? = null,
    @SerializedName("supportedGenerationMethods")
    val supportedGenerationMethods: List<String?>? = null,
    @SerializedName("temperature")
    val temperature: Double? = null,
    @SerializedName("topK")
    val topK: Int? = null,
    @SerializedName("topP")
    val topP: Double? = null,
    @SerializedName("version")
    val version: String? = null
)
