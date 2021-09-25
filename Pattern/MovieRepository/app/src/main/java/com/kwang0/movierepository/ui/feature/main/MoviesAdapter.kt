package com.kwang0.movierepository.ui.feature.main

import android.view.*
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.kwang0.movierepository.R
import com.squareup.picasso.Picasso


class MoviesAdapter(private val presenter: MainContract.Presenter) :
    RecyclerView.Adapter<MoviesAdapter.MovieHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MovieHolder {
        if (viewGroup is RecyclerView) {
            val view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_movie, viewGroup, false)
            return MovieHolder(view)
        } else {
            throw RuntimeException("Not bound to RecyclerView")
        }
    }

    override fun onBindViewHolder(movieHolder: MovieHolder, position: Int) {
        presenter.configureCell(movieHolder, position)
    }

    override fun getItemCount(): Int {
        return presenter.getItemsCount()
    }

    fun refreshData() {
        notifyDataSetChanged()
    }


    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        MovieCellView, View.OnClickListener {

        private val imageView = itemView.findViewById(R.id.image) as ImageView

        init {
            itemView.setOnClickListener(this)
        }

        override fun displayImage(url: String) {
            Picasso.get()
                .load(url)
                .placeholder(R.drawable.movie_placeholder)
                .into(imageView)
        }

        override fun onClick(view: View) {
            presenter.onItemClick(adapterPosition)
        }

    }

    interface MovieCellView {

        fun displayImage(url: String)

    }
}
