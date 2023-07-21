package com.dkexception.palminpalm.feature.more.domain

import com.dkexception.palminpalm.core.network.model.GetAllModelsListDTO

fun GetAllModelsListDTO?.toPaLMModelList(): List<PaLMModel> = this?.models?.map {
    PaLMModel(
        name = it.name ?: "Model Name",
        version = it.version ?: "0.0",
        displayName = it.displayName ?: "Model display name",
        description = it.description ?: "Model description",
        preconfiguredTemperature = it.temperature ?: 0.0
    )
}.orEmpty()
