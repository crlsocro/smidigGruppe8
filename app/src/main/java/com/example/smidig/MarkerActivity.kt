package com.example.smidig

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.smidig.History.HistoryActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MarkerActivity : AppCompatActivity() {

    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                return@OnNavigationItemSelectedListener false
            }
            R.id.homepage -> {
                val intent = Intent(this@MarkerActivity, SigninActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@MarkerActivity, HistoryActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marker)
        supportActionBar?.hide()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation4)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)

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
            val i = Intent(this, RouteActivity::class.java)
            startActivity(i)
        }

    }

}