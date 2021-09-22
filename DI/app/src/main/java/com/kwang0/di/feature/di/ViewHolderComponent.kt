package com.kwang0.di.feature.di

import androidx.recyclerview.widget.RecyclerView
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ViewHolderScope

@ViewHolderScope
@DefineComponent(parent = SingletonComponent::class)
interface ViewHolderComponent{

    @DefineComponent.Builder
    interface Builder {
        fun build(): ViewHolderComponent
        fun viewHolder(@BindsInstance viewHolder: RecyclerView.ViewHolder?): Builder
    }
}
