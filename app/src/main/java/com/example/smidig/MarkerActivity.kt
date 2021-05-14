package com.example.smidig

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MarkerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marker)


        var webView = findViewById<WebView>(R.id.pinMap)
        webView.setInitialScale(1)
        webView.webChromeClient = WebChromeClient()
        webView.settings.allowFileAccess = true
        webView.settings.pluginState = WebSettings.PluginState.ON
        webView.settings.pluginState = WebSettings.PluginState.ON_DEMAND
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true

        webView.loadUrl("https://www.google.com/maps/d/embed?mid=1Xx48rtXPMkjq9f7B7NXAW-gcQ5l7h-AT&hl=en")

        var completeBtn = findViewById<Button>(R.id.completeBtn)
        completeBtn.setOnClickListener{
            val i = Intent(this, PostActivity::class.java)
            startActivity(i)
        }

    }

}