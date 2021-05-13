package com.example.smidig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        var btnLogin = findViewById<Button>(R.id.login)
        btnLogin.setOnClickListener {
            val i = Intent(this, MapsActivity::class.java)
            startActivity(i)
        }
        var btnSignUp = findViewById<Button>(R.id.register)
        btnSignUp.setOnClickListener {
            val i = Intent(this, SignUpActivity::class.java)
            startActivity(i)
        }
        var btnGuest = findViewById<Button>(R.id.continues)
        btnGuest.setOnClickListener {
            val i = Intent(this, QuizActivity::class.java)
            startActivity(i)
        }

    }

}