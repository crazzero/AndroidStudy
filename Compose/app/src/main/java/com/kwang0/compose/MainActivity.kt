package com.kwang0.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kwang0.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Replace from setContentView(layoutResId: Int)
        // setContent must have (@Composable) -> Unit type component UI
        setContent {
            BaseContainer {
                Surface(color = MaterialTheme.colors.background) {
                    GreetingList(listOf("kwang0"))
                }
            }
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GreetingList(listOf("kwang0"))
                }
            }
        }
    }
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        GreetingList(listOf(
            "sample1",
            "sample2",
        ))
    }
}