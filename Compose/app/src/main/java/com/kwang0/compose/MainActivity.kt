package com.kwang0.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kwang0.compose.ui.custom.GreetingList
import com.kwang0.compose.ui.custom.GreetingWithDivider
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