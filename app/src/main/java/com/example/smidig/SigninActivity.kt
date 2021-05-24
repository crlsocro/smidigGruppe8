package com.example.smidig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.smidig.History.HistoryActivity
import com.example.smidig.database.*
import com.example.smidig.quiz.QuizActivity

class SigninActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        var username : String = ""
        var password : String = ""

        var emailEditText = findViewById<EditText>(R.id.emailEditText)
        var passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        emailEditText.setText("testUser1")
        passwordEditText.setText("testUser1")

        var btnSignin = findViewById<Button>(R.id.SigninBtn)
        btnSignin.setOnClickListener {

            username = emailEditText.text.toString()
            password = passwordEditText.text.toString()

            val i = Intent(this, HistoryActivity::class.java)
            startActivity(i)
        }

        var loginDAO : LoginDao = MultiDatabase.get(this).getLDao()
        var quizTest : Login = Login(0, "testUser1", "testUser1")
        loginDAO.addLogin(quizTest)

        var test : Login = loginDAO.getUser(username)
        println("test = " + test)
        println("test.size")
    }

    fun toRegister(view: View) {
        val intent = Intent(this, SignUpActivity::class.java).apply {

        }
        startActivity(intent)
    }
}
//input username&password
//check database for that user
//check if password matches
//Send to next screen if true, makeToast if not