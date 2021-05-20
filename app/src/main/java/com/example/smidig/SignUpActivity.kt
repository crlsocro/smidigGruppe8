package com.example.smidig

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.smidig.database.Quiz


class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

        var submit = findViewById<Button>(R.id.submitR)
        submit.setOnClickListener {
            val i = Intent(this, SigninActivity::class.java)
            startActivity(i)
        }

        fun sendUserToDatabase(view: View) {
            val email = findViewById<EditText>(R.id.editEmail)
            val password = findViewById<EditText>(R.id.editPassword)
            var testB = Quiz(0, "Test", "Foo@test.com", "food")

        }
    }
}