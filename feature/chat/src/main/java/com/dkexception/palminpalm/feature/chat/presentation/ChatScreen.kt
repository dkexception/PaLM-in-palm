@file:OptIn(ExperimentalMaterial3Api::class)

package com.dkexception.palminpalm.feature.chat.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun ChatScreen(
    state: ChatState = ChatState(),
    onEvent: ((ChatEvent) -> Unit)? = null
) {

    val listState: LazyListState = rememberLazyListState()

    LaunchedEffect(state.chatList.size) {
        listState.scrollToItem(state.chatList.size - 1)
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .windowInsetsPadding(WindowInsets.Companion.statusBars)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        LazyColumn(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(state.chatList) {
                ChatListItem(it)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                value = state.chatPrompt,
                onValueChange = {
                    onEvent?.invoke(ChatEvent.OnPromptChange(it))
                },
                label = { Text("Enter your prompt") },
                keyboardActions = KeyboardActions(
                    onSend = if (state.isLoading) null else {
                        { onEvent?.invoke(ChatEvent.OnPromptSubmit) }
                    }
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 6.dp)
            ) {
                SendButton(isLoading = state.isLoading) {
                    onEvent?.invoke(ChatEvent.OnPromptSubmit)
                }
            }
        }
    }
}

@Composable
private fun ChatListItem(model: ChatModel) {

    val clipboardManager = LocalClipboardManager.current

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = when (model.userType) {
            ChatUserType.PALM -> Alignment.CenterStart
            ChatUserType.USER -> Alignment.CenterEnd
        }
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .widthIn(min = 0.dp, max = LocalConfiguration.current.screenWidthDp.dp * .6f)
                .background(
                    when (model.userType) {
                        ChatUserType.PALM -> MaterialTheme.colorScheme.primaryContainer
                        ChatUserType.USER -> MaterialTheme.colorScheme.tertiaryContainer
                    }
                )
                .clickable {
                    if (model.chatType == ChatType.TEXT) {
                        clipboardManager.setText(AnnotatedString(model.textOrUrl))
                    }
                }
        ) {
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(16.dp),
                text = model.textOrUrl
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
private fun SendButton(
    isLoading: Boolean,
    onClickAction: () -> Unit
) {
    if (isLoading) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .fillMaxHeight()
                .size(50.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            )
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Icon(imageVector = Icons.Filled.Send, contentDescription = "Send")
            }
        }
    } else {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .fillMaxHeight()
                .size(50.dp),
            elevation = CardDefaults.cardElevation(1.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceTint
            ),
            onClick = onClickAction
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Icon(imageVector = Icons.Filled.Send, contentDescription = "Send")
            }
        }
    }
}

@Preview
@Composable
private fun ChatScreenPreview() = ChatScreen(
    state = ChatState(chatList = ChatModel.getDummyChatListForUIPreview())
)

@Preview
@Composable
private fun ChatScreenPreviewLoading() = ChatScreen(
    state = ChatState(
        chatList = ChatModel.getDummyChatListForUIPreview(),
        isLoading = true
    )
)
