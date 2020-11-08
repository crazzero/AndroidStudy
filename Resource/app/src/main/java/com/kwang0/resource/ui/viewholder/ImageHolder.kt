package com.kwang0.resource.ui.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import com.kwang0.resource.R
import com.kwang0.resource.ResUtils
import com.kwang0.resource.model.ResourceEntity
import kotlinx.android.synthetic.main.holder_resource_image.view.*

class ImageHolder(itemView: View) : BaseHolder(itemView) {

    fun bind(resourceEntity: ResourceEntity) {
        itemView.textImageTitle.text = ResUtils.getString(resourceEntity.title)

        when (resourceEntity.type) {
            ResourceEntity.COLOR_TYPE -> {
                if (resourceEntity.payload is String) {
                    ResUtils.getColor(resourceEntity.payload)?.also {
                        itemView.imageValue.setBackgroundColor(it)
                    }
                }
            }

            ResourceEntity.DRAWABLE_TYPE -> {
                if (resourceEntity.payload is Int) {
                    itemView.imageValue.background = ResUtils.getDrawable(resourceEntity.payload)
                }
            }

            ResourceEntity.ANIMATION_TYPE -> {
                if (resourceEntity.payload is String) {
                    ResUtils.getAnimation(resourceEntity.payload)?.also {
                        itemView.imageValue.animation = it
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance(parent: ViewGroup): ImageHolder {
            return ImageHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.holder_resource_image, parent, false)
            )
        }
    }
}
