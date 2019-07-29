package com.example.qiita

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import kotlinx.android.synthetic.main.fragment_web_view.view.*


/**
 * タップした記事をWebViewを表示するクラス
 */
class WebViewFragment(private var articleItems: ArticleItems) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("WebViewFragment", "View")

        //タップした記事のwebページを表示
        val articleView: WebView = view.webView
        articleView.webViewClient
        articleView.loadUrl(articleItems.url)

    }

}
