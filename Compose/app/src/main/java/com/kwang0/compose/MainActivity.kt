package com.kwang0.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
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
                    GreetingWithDivider()
                }
            }
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
fun ComposeCounter(names: List<String> = listOf("Line 1", "Line 2")) {
    val counterState = remember { mutableStateOf(0) }

    Column {
        names.forEach {
            Greeting(name = it)
            Divider(color = Color.Black)
        }
        Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            },
        )
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count - 1) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count > 5) Color.Green else Color.White
        )
    ) {
        Text("I've been clicked $count times")
    }
}

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