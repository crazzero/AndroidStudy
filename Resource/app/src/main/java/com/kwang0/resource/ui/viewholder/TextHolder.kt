package com.kwang0.resource.ui.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kwang0.resource.R
import com.kwang0.resource.ResUtils
import com.kwang0.resource.model.ResourceEntity
import kotlinx.android.synthetic.main.holder_resource_text.view.*

class TextHolder(itemView: View) : BaseHolder(itemView) {

    fun bind(resourceEntity: ResourceEntity) {
        itemView.textTextTitle.text = ResUtils.getString(resourceEntity.title)

        if (resourceEntity.payload is String) {
            itemView.textValue.text = ResUtils.getString(resourceEntity.payload)
        }
    }

    companion object {
        fun newInstance(parent: ViewGroup): TextHolder {
            return TextHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.holder_resource_text, parent, false)
            )
        }
    }
}
