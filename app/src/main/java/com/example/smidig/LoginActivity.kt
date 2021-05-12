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

        var btnContinue = findViewById<Button>(R.id.continues)
        btnContinue.setOnClickListener {
            val i = Intent(this, FrontPageActivity::class.java)
            startActivity(i)
        }
    }

}