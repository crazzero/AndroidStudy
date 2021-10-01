package com.kwang0.di.feature.viewholder

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kwang0.di.R
import com.kwang0.di.databinding.HolderMainBinding
import com.kwang0.di.feature.di.ViewHolderComponent
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), MainViewHolderContract.ViewHolder {

    @EntryPoint
    @InstallIn(ViewHolderComponent::class)
    interface MainViewHolderEntryPoint {
        fun getPresenter(): MainViewHolderContract.Presenter
    }

    private var binding: HolderMainBinding? = null


    private var presenter: MainViewHolderContract.Presenter? = null

//    @Inject
//    lateinit var presenter: MainViewHolderContract.Presenter

    init {
        binding = HolderMainBinding.bind(itemView)
//        presenter = EntryPointAccessors.fromView(itemView, MainViewHolderEntryPoint::class.java).getPresenter()
        presenter =
            EntryPoints.get(
                ViewHolderComponent::class.java,
                MainViewHolderEntryPoint::class.java
            ).getPresenter()
    }

    fun bind(text: String) {
        presenter?.call()
        binding?.textMainHolder?.text = text
    }

    override fun onCall() {
        Log.e("ViewHolder", "Call!!!!")
    }

    companion object {
        fun getInstance(viewGroup: ViewGroup): MainViewHolder {
            return MainViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.holder_main, viewGroup, false),
            )
        }
    }
}
