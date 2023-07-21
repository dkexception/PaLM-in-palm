package com.dkexception.palminpalm.core.network.api

import com.dkexception.palminpalm.core.network.BuildConfig
import com.dkexception.palminpalm.core.network.model.GenerateMessageDTO
import com.dkexception.palminpalm.core.network.model.GenerateMessageRequest
import com.dkexception.palminpalm.core.network.model.GetAllModelsListDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PaLMApi {

    @GET("/v1beta2/models")
    suspend fun getAllModelsList(
        @Query("key") key: String = BuildConfig.palmApiKey
    ): GetAllModelsListDTO?

    @POST("/v1beta2/models/{model}:generateMessage")
    suspend fun generateMessage(
        @Path("model") model: String = "chat-bison-001",
        @Query("key") key: String = BuildConfig.palmApiKey,
        @Body request: GenerateMessageRequest
    ): GenerateMessageDTO?
}
