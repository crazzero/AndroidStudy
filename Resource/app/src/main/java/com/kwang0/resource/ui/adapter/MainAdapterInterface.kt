package com.kwang0.resource.ui.adapter

import com.kwang0.resource.model.ResourceEntity

interface MainAdapterInterface {
    fun setItems(items: List<ResourceEntity>)
    fun addItems(items: List<ResourceEntity>)
}
