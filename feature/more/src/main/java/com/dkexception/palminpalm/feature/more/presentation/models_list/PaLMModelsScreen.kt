package com.dkexception.palminpalm.feature.more.presentation.models_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dkexception.palminpalm.feature.more.domain.PaLMModel

@Composable
internal fun PaLMModelsScreen(
    state: PaLMModelsState = PaLMModelsState(),
    onEvent: ((PaLMModelsEvent) -> Unit)? = null
) {

    if (state.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(Modifier.fillMaxSize()) {
                items(state.models) {
                    PaLMModelListItem(it)
                }
            }
        }
    }
}

@Composable
private fun PaLMModelListItem(model: PaLMModel) {

    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }

    Box(
        Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable { isExpanded = !isExpanded }
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Name: ")
                    }
                    append(model.name)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(model.description)

            AnimatedVisibility(visible = isExpanded) {
                Column(Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(Modifier.fillMaxWidth(), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Display Name: ")
                            }
                            append(model.displayName)
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Temperature: ")
                            }
                            append(model.preconfiguredTemperature.toString())
                        }
                    )
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Preview
@Composable
private fun PaLMModelsScreenPreviewLoading() = PaLMModelsScreen(
    state = PaLMModelsState(isLoading = true)
)

@Preview
@Composable
private fun PaLMModelsScreenPreviewWithData() = PaLMModelsScreen(
    state = PaLMModelsState(
        models = listOf(
            PaLMModel(
                name = "models/chat-bison-001",
                version = "001",
                displayName = "Chat Bison",
                description = "Chat-optimized generative language model.",
                preconfiguredTemperature = 0.25
            )
        )
    )
)
