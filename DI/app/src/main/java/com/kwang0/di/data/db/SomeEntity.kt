package com.kwang0.di.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "some_entity")
public data class SomeEntity(
//internal data class SomeEntity(
    @PrimaryKey
    val type: String,
    val name: String,
)
