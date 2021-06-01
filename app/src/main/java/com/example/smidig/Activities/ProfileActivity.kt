package com.example.smidig.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.smidig.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity: AppCompatActivity() {

    //Navigation through screens via footer
    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.homepage -> {
                val intent = Intent(this@ProfileActivity, MapsActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@ProfileActivity, HistoryActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                val intent = Intent(this@ProfileActivity,  SigninActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.hide()

        //Onclick
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation8)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)
        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, SigninActivity::class.java)
            startActivity(i)
        }
    }
}