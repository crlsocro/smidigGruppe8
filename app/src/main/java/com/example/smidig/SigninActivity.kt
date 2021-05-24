package com.example.smidig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.smidig.History.HistoryActivity
import com.example.smidig.quiz.QuizActivity

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        var emailEditText = findViewById<EditText>(R.id.emailEditText)
        var passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        emailEditText.setText("testUser1")
        passwordEditText.setText("testUser1")

        var btnSignin = findViewById<Button>(R.id.SigninBtn)
        btnSignin.setOnClickListener {
            val i = Intent(this, HistoryActivity::class.java)
            startActivity(i)
        }
    }

    fun toRegister(view: View) {
        val intent = Intent(this, SignUpActivity::class.java).apply {

        }
        startActivity(intent)
    }
}