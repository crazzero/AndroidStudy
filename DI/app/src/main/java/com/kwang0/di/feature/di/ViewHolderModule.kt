package com.kwang0.di.feature.di

import androidx.recyclerview.widget.RecyclerView
import com.kwang0.di.feature.MainViewHolder
import com.kwang0.di.feature.MainViewHolderPresenter
import com.kwang0.di.feature.contract.MainViewHolderContract
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn(ViewHolderComponent::class)
abstract class MainHolderModule{

    @Binds
    @ViewHolderScope
    abstract fun bindHolder(view: MainViewHolder): MainViewHolderContract.ViewHolder

    @Binds
    @ViewHolderScope
    abstract fun bindPresenter(impl: MainViewHolderPresenter): MainViewHolderContract.Presenter

}

@Module
@InstallIn(ViewHolderComponent::class)
object MainViewHolderModule{

    @Provides
    @ViewHolderScope
    fun bindViewHolder(viewHolder: RecyclerView.ViewHolder): MainViewHolder {
        return viewHolder as MainViewHolder
    }
}
