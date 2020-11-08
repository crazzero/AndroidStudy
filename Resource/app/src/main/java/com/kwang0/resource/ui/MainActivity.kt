package com.kwang0.resource.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kwang0.resource.R
import com.kwang0.resource.model.ResourceEntity
import com.kwang0.resource.ui.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            itemAnimator = null
            adapter = this@MainActivity.adapter
        }.also {
            adapter.setItems(items)
        }
    }


    private val items = listOf(
        ResourceEntity("resource.sample.string.title", ResourceEntity.STRING_TYPE, "string_example"),
        ResourceEntity("resource.sample.color.title", ResourceEntity.COLOR_TYPE, "color_example"),
        ResourceEntity("resource.sample.drawable.title", ResourceEntity.DRAWABLE_TYPE, R.drawable.drawable_example),
        ResourceEntity("resource.sample.animation.title", ResourceEntity.ANIMATION_TYPE, "animation_example")
    )
}
