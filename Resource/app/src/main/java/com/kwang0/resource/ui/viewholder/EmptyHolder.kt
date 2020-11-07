package com.kwang0.resource.ui.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kwang0.resource.R

class EmptyHolder(itemView: View) : BaseHolder(itemView) {

    fun bind() {}

    companion object {
        fun newInstance(parent: ViewGroup): EmptyHolder {
            return EmptyHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.holder_resource_image, parent, false)
            )
        }
    }
}
