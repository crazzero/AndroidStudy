package com.kwang0.di.feature

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kwang0.di.databinding.HolderMainBinding

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding: HolderMainBinding? = null

    init {
        binding = HolderMainBinding.inflate(LayoutInflater.from(itemView.context), null, false)
    }

    fun bind(text: String) {
        binding?.textMainHolder?.text = text
    }
}
