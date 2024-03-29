package com.example.smidig.Activities

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smidig.*
import com.google.android.material.bottomnavigation.BottomNavigationView

//The InfoActivity is inspired from https://www.youtube.com/watch?v=b21fiIyOW4A&t=4896s

class InfoActivity: AppCompatActivity() {
    //Navigation through screens via footer
    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.homepage -> {
                val intent = Intent(this@InfoActivity, MapsActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@InfoActivity, HistoryActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                val intent = Intent(this@InfoActivity, ProfileActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        supportActionBar?.hide()

        //Onclick on goBack and infoBtn
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation4)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)

        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, HistoryActivity::class.java)
            startActivity(i)
        }

        //Setting up webview, inspired by https://developers.google.com/maps/documentation
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

        webView.loadUrl("https://www.google.com/maps/d/embed?mid=1JKsxtkyA7Opg17O2bQ0iOGjaGJJKXqJo")

        //Onclick on complete to go forward to next screen and onclick to popup
        var completeBtn = findViewById<Button>(R.id.completeBtn)
        completeBtn.setOnClickListener{
            val i = Intent(this, HistoryRouteActivity::class.java)
            startActivity(i)
        }

        var infoBtn = findViewById<ImageView>(R.id.infoIcon)
        infoBtn.setOnClickListener{
            val popUp = PopupMenu(this, infoBtn)
            val popUpToast = Toast.makeText(applicationContext,
                "Klikk start for å følge denne løypen \n",
                Toast.LENGTH_SHORT).show()
        }
    }
}