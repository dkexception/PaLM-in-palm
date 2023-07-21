package com.dkexception.palminpalm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dkexception.palminpalm.ui.theme.PaLMInPalmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PaLMInPalmTheme {
                PaLMNavigationManager()
            }
        }
    }
}
