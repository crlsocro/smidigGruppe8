package com.example.smidig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)


        var btnSignin = findViewById<Button>(R.id.SigninBtn)
        btnSignin.setOnClickListener {
            val i = Intent(this, FrontPageActivity::class.java)
            startActivity(i)
        }
    }
}