package com.example.smidig

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.smidig.database.Login
import com.example.smidig.database.LoginDao
import com.example.smidig.database.MultiDatabase
import com.example.smidig.database.Quiz


class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

        var loginDAO : LoginDao = MultiDatabase.get(this).getLDao()


        var submit = findViewById<Button>(R.id.submitR)
        submit.setOnClickListener {

            val username = findViewById<EditText>(R.id.editUsername)
            val password = findViewById<EditText>(R.id.editPassword)

            var user : Login = Login(0, username.text.toString(), password.text.toString())
            loginDAO.addLogin(user)

            println(user)

            val i = Intent(this, SigninActivity::class.java)
            startActivity(i)
        }

    }
}