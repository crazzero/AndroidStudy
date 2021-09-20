package com.kwang0.compose.ui.custom

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GreetingWithDivider() {
    Column {
        Greeting(name = "kwang0")
        Divider(color = Color.Black)
        Greeting(name = "")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun GreetingList(names: List<String>) {
    val isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(
        if (isSelected) {
            Color.Red
        } else {
            Color.Transparent
        }
    )

    names.forEach { name ->
        Text(
            text = "Hello $name!",
            modifier = Modifier
                .padding(24.dp)
                .background(color = backgroundColor)
        )
    }
}
