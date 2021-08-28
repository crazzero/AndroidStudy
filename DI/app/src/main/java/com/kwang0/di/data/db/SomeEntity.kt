package com.kwang0.di.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "some_entity")
internal data class SomeEntity(
    @PrimaryKey
    val type: String,
    val name: String,
)
