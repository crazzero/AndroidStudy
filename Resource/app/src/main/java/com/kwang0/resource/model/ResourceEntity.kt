package com.kwang0.resource.model

class ResourceEntity(
    val title: String,
    val type: Int,
    val payload: Any
) {

    companion object {
        const val STRING_TYPE = 0
        const val COLOR_TYPE = 1
        const val DRAWABLE_TYPE = 2
        const val ANIMATION_TYPE = 3
    }
}
