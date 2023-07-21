package com.dkexception.palminpalm.feature.more.data

import com.dkexception.palminpalm.core.common.di.StandardDispatchers
import com.dkexception.palminpalm.core.network.api.PaLMApi
import com.dkexception.palminpalm.feature.more.domain.PaLMModel
import com.dkexception.palminpalm.feature.more.domain.toPaLMModelList
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PaLMModelsRepository @Inject constructor(
    private val paLMApi: PaLMApi,
    private val standardDispatchers: StandardDispatchers
) {

    suspend fun getModelsList(): List<PaLMModel> = withContext(standardDispatchers.io) {
        try {
            paLMApi.getAllModelsList().toPaLMModelList()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
