package com.dkexception.palminpalm.feature.more.presentation.models_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dkexception.palminpalm.feature.more.data.PaLMModelsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaLMModelsViewModel @Inject constructor(
    private val repository: PaLMModelsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(PaLMModelsState())
    val state = _state.asStateFlow()

    init {
        getAllModels()
    }

    fun onEvent(event: PaLMModelsEvent) {

    }

    private fun getAllModels() = viewModelScope.launch {

        _state.update { it.copy(isLoading = true) }

        val response = repository.getModelsList()

        if (response.isEmpty()) {
            _state.update { it.copy(isLoading = false, errorMessage = "Unable to fetch list!") }
        } else {
            _state.update { it.copy(isLoading = false, errorMessage = null, models = response) }
        }
    }
}
