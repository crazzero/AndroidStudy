package com.kwang0.di.data.api

import kotlinx.serialization.Serializable

@Serializable
data class SomeResponse(
    val type: String,
    val name: String,
)
