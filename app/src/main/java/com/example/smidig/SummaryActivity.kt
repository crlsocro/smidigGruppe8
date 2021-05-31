package com.example.smidig

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.Toast
import com.example.smidig.History.HistoryActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

//TODO TITTELEN ER HARD KODET!!

class SummaryActivity : AppCompatActivity() {

    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                return@OnNavigationItemSelectedListener false
            }
            R.id.homepage -> {
                val intent = Intent(this@SummaryActivity, MapsActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@SummaryActivity, HistoryActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                val intent = Intent(this@SummaryActivity, SigninActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        supportActionBar?.hide()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation6)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)
        val mapBtn = findViewById<ImageView>(R.id.buttonBG)
        mapBtn.setOnClickListener {
            toMap()
        }

    }

    private fun toMap() {
        val intent = Intent(this, MapsActivity::class.java).apply {
        }
        startActivity(intent)
    }
}