package com.kwang0.movierepository.ui.feature.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.kwang0.movierepository.R
import com.kwang0.movierepository.ui.base.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailContract.View {

    companion object {
        const val EXTRA_MOVIE_ID = "MOVIE_ID"
        fun launch(activity: Activity, movieId: Int) {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_ID, movieId)
            activity.startActivity(intent)
        }
    }

    @Inject lateinit var presenter: DetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUpActionBar()

        informPresenterViewIsReady()
    }

    private fun setUpActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun informPresenterViewIsReady() {
        presenter.viewReady()
    }

    override fun displayImage(url: String) {
        Picasso.get()
            .load(url)
            .into(image_movie)
    }

    override fun displayTitle(title: String) {
        setTitle(title)
    }

    override fun displayVoteAverage(voteAverage: String) {
        text_voteAverage.text = voteAverage
    }

    override fun displayReleaseDate(releaseDate: String) {
        text_releaseDate.text = releaseDate
    }

    override fun displayOverview(overview: String) {
        text_overview.text = overview
    }

    override fun goToBack() {
        onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                presenter.navUpSelected()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

}
