package com.kwang0.resource.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kwang0.resource.model.ResourceEntity
import com.kwang0.resource.ui.viewholder.BaseHolder
import com.kwang0.resource.ui.viewholder.EmptyHolder
import com.kwang0.resource.ui.viewholder.ImageHolder
import com.kwang0.resource.ui.viewholder.TextHolder

class MainAdapter : RecyclerView.Adapter<BaseHolder>(), MainAdapterInterface {

    private val items: ArrayList<ResourceEntity> = arrayListOf()

    override fun setItems(items: List<ResourceEntity>) {
        this.items.clear()

        this.addItems(items)
    }

    override fun addItems(items: List<ResourceEntity>) {
        items.forEach { this.items.add(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        return when (viewType) {
            ResourceEntity.ANIMATION_TYPE, ResourceEntity.COLOR_TYPE, ResourceEntity.DRAWABLE_TYPE -> {
                ImageHolder.newInstance(parent)
            }

            ResourceEntity.STRING_TYPE -> {
                TextHolder.newInstance(parent)
            }

            else -> {
                EmptyHolder.newInstance(parent)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        when (holder) {
            is ImageHolder -> holder.bind()
            is TextHolder -> holder.bind()
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }

    override fun onViewRecycled(holder: BaseHolder) {
        holder.recycled()
    }
}
