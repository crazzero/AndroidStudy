package com.kwang0.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.kwang0.compose.ui.theme.ComposeTheme

// Sample container for composable content
@Composable
fun BaseContainer(content: @Composable () -> Unit) {
    ComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}
