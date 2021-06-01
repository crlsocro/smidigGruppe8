package com.example.smidig.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import android.widget.TextView
import com.example.smidig.R
import com.example.smidig.database.*



class SigninActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        //Empty variables here to prevent them from being local
        var username : String = ""
        var password : String = ""

        //Setting the default login details to a soon-to-be-created user for fast access and demo
        var emailEditText = findViewById<EditText>(R.id.emailEditText)
        var passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        emailEditText.setText("keenHistorian")
        passwordEditText.setText("Historian")

        //Getting access to DAO
        var loginDAO : LoginDao = MultiDatabase.get(this).getLDao()

        //Creating a user with the default edittext values for fast access
        //try/catch not really used here
        var user : Login = Login(0, "", "")
        try {
            user = Login(0, "keenHistorian", "Historian")
            loginDAO.addLogin(user)
        }catch (e : NullPointerException){
            println(e)
        }

        var btnSignin = findViewById<ImageView>(R.id.buttonBG)
        val btnRegister = findViewById<TextView>(R.id.register)

        //The actual login testing
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

        //Makes a toast when clicking the info button
        var infoBtn = findViewById<ImageView>(R.id.infoIcon)
        infoBtn.setOnClickListener{
            val popUp = PopupMenu(this, infoBtn)
            val popUpToast = Toast.makeText(applicationContext,
                "Logg inn for å kunne lagre \n" +
                    "hvor langt du har komt og \n" +
                    "annen generell informasjon",
                Toast.LENGTH_SHORT).show()
        }

        //Takes you to the register page
        btnRegister.setOnClickListener{
            val i = Intent(this, SignUpActivity::class.java)
            startActivity(i)
        }

        //Takes you to the map page
        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, MapsActivity::class.java)
            startActivity(i)
        }
    }
}