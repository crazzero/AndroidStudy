package com.kwang0.resource.model

interface ResourceEntity {
    val title: String
    val type: Int
    val key: String
    val value: String

    companion object {
        const val ANIMATION_TYPE = 0
        const val COLOR_TYPE = 1
        const val STRING_TYPE = 2
        const val DRAWABLE_TYPE = 3
    }
}
