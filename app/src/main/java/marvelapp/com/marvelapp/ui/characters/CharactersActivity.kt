package marvelapp.com.marvelapp.ui.characters

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import android.view.View
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import marvelapp.com.marvelapp.R
import marvelapp.com.marvelapp.model.Result
import marvelapp.com.marvelapp.ui.BaseActivity
import javax.inject.Inject


class CharactersActivity : BaseActivity(), CharactersView {

    @Inject lateinit var presenter: CharactersPresenter

    var adapter: CharactersAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setView(this)
        setupRecyclerView()
        supportActionBar?.title = getString(R.string.marvel_characters)
        presenter.getCharacters(true)

    }


    fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        adapter = CharactersAdapter(mutableListOf())
        recyclerView.adapter = adapter
        // infinite loading
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount = layoutManager.itemCount
                val visibleItemCount = layoutManager.childCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                if (visibleItemCount + lastVisibleItem + presenter.VISIBLE_THRESHOLD >= totalItemCount) {
                    presenter.getCharacters(false)
                }
            }
        })

    }

    override fun setCharacters(characters: List<Result>?) {
        characters?.let { adapter?.setItems(it) }
    }

    override fun addCharacters(characters: List<Result>?) {
        characters?.let { adapter?.addItems(it) }
    }

    override fun inject() {
        AndroidInjection.inject(this)
    }

    override fun showBottomLoading() {
        bottomProgressDialog.visibility = View.VISIBLE
    }

    override fun hideBottomLoading() {
        bottomProgressDialog.visibility = View.GONE

    }

    override fun onDestroy() {
        presenter.onStop()
        super.onDestroy()
    }

}
