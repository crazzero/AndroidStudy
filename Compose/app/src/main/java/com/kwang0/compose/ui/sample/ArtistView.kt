package com.kwang0.compose.ui.sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kwang0.compose.R

@Composable
fun ArtistCard1() {
    Text("Alfred Sisley")
    Text("3 minutes ago")
}

@Composable
fun ArtistCard2() {
    Column {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}

@Composable
fun ArtistCard3(artist: Artist) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Content Description",
        )
        Column {
            Text(artist.name)
            Text(artist.lastSeenOnline)
        }
    }
}

@Composable
fun ArtistCard4(artist: Artist) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Image(
            painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Content Description",
        )
        Column {
            Text(artist.name)
            Text(artist.lastSeenOnline)
        }
    }
}

@Composable
fun ArtistCard5(
    artist: Artist,
    onClick: () -> Unit,
) {
    val padding = 16.dp
    Column(
        Modifier
            .clickable(onClick = onClick)
            .padding(padding)
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Content Description",
            )
            Column {
                Text(artist.name)
                Text(artist.lastSeenOnline)
            }
        }
        Spacer(Modifier.size(padding))
        Card(elevation = 4.dp) {
            Image(
                painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Content Description",
            )
        }
    }
}

@Composable
fun ArtistCard6(
    artist: Artist,
    onClick: () -> Unit,
) {
    val padding = 16.dp
    Column(
        Modifier
            .padding(padding)
            .clickable(onClick = onClick)
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Content Description",
            )
            Column {
                Text(artist.name)
                Text(artist.lastSeenOnline)
            }
        }
        Spacer(Modifier.size(padding))
        Card(elevation = 4.dp) {
            Image(
                painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Content Description",
            )
        }
    }
}
