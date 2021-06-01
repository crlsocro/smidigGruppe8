package com.example.smidig.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.smidig.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        //Waits two seconds then takes you to the main/maps screen
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MapsActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}

