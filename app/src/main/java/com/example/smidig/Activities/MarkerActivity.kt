package com.example.smidig.Activities

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smidig.R
import com.google.android.material.bottomnavigation.BottomNavigationView

//Most of the code in this activity is inspired from https://developers.google.com/maps/documentation/android-sdk/marker
class MarkerActivity : AppCompatActivity() {

    //Navigation through screens via footer
    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.homepage -> {
                val intent = Intent(this@MarkerActivity, MapsActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@MarkerActivity, HistoryActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                val intent = Intent(this@MarkerActivity, SigninActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

 //https://developers.google.com/maps/documentation/android-sdk/marker
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

        webView.loadUrl("https://www.google.com/maps/d/embed?mid=1JKsxtkyA7Opg17O2bQ0iOGjaGJJKXqJo")

        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, MapsActivity::class.java)
            startActivity(i)
        }

        var completeBtn = findViewById<ImageView>(R.id.buttonBG)
        completeBtn.setOnClickListener{
            val i = Intent(this, RouteActivity::class.java)
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