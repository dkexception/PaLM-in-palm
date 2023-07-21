package com.dkexception.palminpalm.feature.chat.presentation.standalone

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dkexception.palminpalm.feature.chat.presentation.ChatRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PaLMChatTheme {
                ChatRoute.Content()
            }
        }
    }
}
