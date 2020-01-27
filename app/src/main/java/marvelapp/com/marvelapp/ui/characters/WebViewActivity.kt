package marvelapp.com.marvelapp.ui.characters

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_webview.*
import marvelapp.com.marvelapp.R
import marvelapp.com.marvelapp.ui.BaseActivity


class WebViewActivity : BaseActivity() {


    companion object {
        const val MARVEL_WIKI_URL = "https://en.wikipedia.org/wiki/Marvel_Universe"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        setupWebView()
        supportActionBar?.hide()
    }

    private fun setupWebView() {

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl(MARVEL_WIKI_URL)
    }


    override fun inject() {
        AndroidInjection.inject(this)
    }

}
