package com.kwang0.movierepository.extension

import android.app.Activity
import com.kwang0.movierepository.presentation.view.DetailActivity

fun Activity.navigateToDetail(movieId: Int){
    DetailActivity.launch(this, movieId)
}
