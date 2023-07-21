package com.dkexception.palminpalm.feature.more.presentation.models_list

import com.dkexception.palminpalm.feature.more.domain.PaLMModel

data class PaLMModelsState(

    val isLoading: Boolean = false,

    val errorMessage: String? = null,

    val models: List<PaLMModel> = listOf()
)
