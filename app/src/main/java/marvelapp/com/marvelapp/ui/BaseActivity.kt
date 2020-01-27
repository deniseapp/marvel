package marvelapp.com.marvelapp.ui

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_base.*
import marvelapp.com.marvelapp.R


abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun showError(errorMessage: String) {
        Snackbar.make(findViewById(android.R.id.content), errorMessage, Snackbar.LENGTH_LONG)
                .setActionTextColor(Color.WHITE)
                .show()
    }

    protected abstract fun inject()
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setContentView(layoutResID: Int) {
        val coordinatorLayout = LayoutInflater.from(this).inflate(R.layout.activity_base,  root, false)
        val activityContainer: FrameLayout = coordinatorLayout.findViewById(R.id.layoutContainer)

        layoutInflater.inflate(layoutResID, activityContainer, true)

        super.setContentView(coordinatorLayout)
    }

    override fun hideLoading() {
        loadingProgressBar.visibility = View.GONE
        layoutContainer.visibility = View.VISIBLE
    }

    override fun showLoading() {
        loadingProgressBar.visibility = View.VISIBLE
        layoutContainer.visibility = View.GONE
    }

}
