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


//TODO crashing when trying to a user that doesnt exist

class SigninActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        var username : String = ""
        var password : String = ""

        var emailEditText = findViewById<EditText>(R.id.emailEditText)
        var passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        emailEditText.setText("keenHistorian")
        passwordEditText.setText("Historian")



        var loginDAO : LoginDao = MultiDatabase.get(this).getLDao()
        var user : Login = Login(0, "", "")

//TODO this try/catch is useless
        try {
            user = Login(0, "keenHistorian", "Historian")
            loginDAO.addLogin(user)
        }catch (e : NullPointerException){
            println(e)
        }


        var btnSignin = findViewById<Button>(R.id.SigninBtn)
        btnSignin.setOnClickListener {

            username = emailEditText.text.toString()
            password = passwordEditText.text.toString()

            var userInput : Login = loginDAO.getUser(username)

            val i = Intent(this, MapsActivity::class.java)

            try {
                if(userInput.password.equals(password)){
                    startActivity(i)
                }
            }catch (e: java.lang.NullPointerException){

            }
        }
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