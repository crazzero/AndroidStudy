package com.kwang0.di.feature

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter :
    RecyclerView.Adapter<MainViewHolder>() {

    private var items: List<String> = arrayListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MainViewHolder {
        if (viewGroup is RecyclerView) {
            return MainViewHolder.getInstance(viewGroup)
        } else {
            throw RuntimeException("Not bound to RecyclerView")
        }
    }

    override fun onBindViewHolder(mainViewHolder: MainViewHolder, position: Int) {
        mainViewHolder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    fun setItems(items: List<String>) {
        this.items = items
    }
}
