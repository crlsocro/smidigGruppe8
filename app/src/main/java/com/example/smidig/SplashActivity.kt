package com.example.smidig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, SigninActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
//splash screen
//TODO: quiz screen
//TODO: map screen
//TODO: route screen
//TODO: post screen
//TODO: sign in screen
//TODO: sign up screen
//TODO: summary screen
