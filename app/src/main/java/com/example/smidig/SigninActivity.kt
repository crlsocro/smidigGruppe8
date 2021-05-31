package com.example.smidig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.smidig.Profile.ProfileActivity
import com.example.smidig.database.*

//TODO change so a user dont need to login. Only when visiting profile or doing a history

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

        try {
            user = Login(0, "keenHistorian", "Historian")
            loginDAO.addLogin(user)
        }catch (e : NullPointerException){
            println(e)
        }


        var btnSignin = findViewById<ImageView>(R.id.buttonBG)
        val btnRegister = findViewById<TextView>(R.id.register)
        btnSignin.setOnClickListener {

            username = emailEditText.text.toString()
            password = passwordEditText.text.toString()

            var userInput : Login = loginDAO.getUser(username)

            val i = Intent(this, ProfileActivity::class.java)

            try {
                if(userInput.password.equals(password)){
                    startActivity(i)
                }
            }catch (e: java.lang.NullPointerException){

            }
        }

        btnRegister.setOnClickListener{
            val i = Intent(this, SignUpActivity::class.java)
            startActivity(i)
        }


    }

}
//input username&password
//check database for that user
//check if password matches
//Send to next screen if true, makeToast if not