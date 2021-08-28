package com.kwang0.di.annotation.hilt_component

import com.kwang0.di.data.db.SomeEntity
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class LoggedUserScope

@LoggedUserScope
@DefineComponent(parent = SingletonComponent::class)
interface SomeComponent {

    @DefineComponent.Builder
    interface Builder {
        fun setUser(@BindsInstance some: SomeEntity): Builder
        fun build(): SomeComponent
    }
}
