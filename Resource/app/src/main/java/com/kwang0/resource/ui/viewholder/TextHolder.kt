package com.kwang0.resource.ui.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kwang0.resource.R

class TextHolder(itemView: View) : BaseHolder(itemView) {

    fun bind() {}

    companion object {
        fun newInstance(parent: ViewGroup): TextHolder {
            return TextHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.holder_resource_text, parent, false)
            )
        }
    }
}
