package com.example.smidig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class SummaryActivity : AppCompatActivity() {

    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                return@OnNavigationItemSelectedListener false
            }
            R.id.homepage -> {
                val intent = Intent(this@SummaryActivity, SigninActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@SummaryActivity, SignUpActivity::class.java)
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
        setContentView(R.layout.activity_summary)
        supportActionBar?.hide()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation6)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)

        //Copied from https://www.geeksforgeeks.org/ratingbar-in-kotlin/
        val rBar = findViewById<RatingBar>(R.id.rBar)
        if (rBar != null) {
            val button = findViewById<Button>(R.id.button)
            button?.setOnClickListener {
                val msg = rBar.rating.toString()
                Toast.makeText(this@SummaryActivity,
                    "Rating is: "+msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun toMap(view: View) {
        val intent = Intent(this, MapsActivity::class.java).apply {
        }
        startActivity(intent)
    }
}