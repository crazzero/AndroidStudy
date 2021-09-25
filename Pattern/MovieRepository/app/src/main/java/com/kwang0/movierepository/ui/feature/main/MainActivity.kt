package com.kwang0.movierepository.ui.feature.main

import android.os.Bundle
import com.kwang0.movierepository.R
import com.kwang0.movierepository.extension.navigateToDetail
import com.kwang0.movierepository.presentation.view.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject lateinit var presenter: MainContract.Presenter

    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpActionBar()

        setUpListView()

        setUpRefreshView()

        informPresenterViewIsReady()
    }

    private fun setUpActionBar() {
        setSupportActionBar(toolbar)
    }

    private fun setUpListView() {
        adapter = MoviesAdapter(presenter)
        recyclerView.adapter = adapter
    }

    private fun setUpRefreshView() {
        refreshLayout.setColorSchemeResources(
            R.color.purple_500,
            R.color.purple_700,
            R.color.teal_200)
        refreshLayout.setOnRefreshListener { presenter.refresh() }
    }

    private fun informPresenterViewIsReady() {
        presenter.viewReady()
    }

    override fun refreshList() {
        adapter.refreshData()
    }

    override fun cancelRefreshDialog() {
        refreshLayout.isRefreshing = false
    }

    override fun navigateToDetailScreen(movieId: Int) {
        navigateToDetail(movieId)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

}
