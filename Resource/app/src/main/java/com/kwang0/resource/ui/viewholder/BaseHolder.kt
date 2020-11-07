package com.kwang0.resource.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun recycled() {
        clear()
    }

    protected open fun clear() {}
}
