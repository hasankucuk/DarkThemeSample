package com.hasankucuk.darkthemesample

import android.annotation.SuppressLint
import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    companion object {
        private const val MOBILER_DEV = "https://www.mobiler.dev"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        prepareWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun prepareWebView() {
        webView.settings.javaScriptEnabled = true
        webView.settings.useWideViewPort = true

        webView.webViewClient = MyWebViewClient()
        webView.loadUrl(MOBILER_DEV)
    }

    private class MyWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return url != MOBILER_DEV
        }

        override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
            handler?.proceed()
        }
    }
}
