package com.example.smidig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.smidig.quiz.QuizActivity

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        var completeBtn = findViewById<Button>(R.id.completeBtn)
        completeBtn.setOnClickListener {
            val i = Intent(this, QuizActivity::class.java)
            startActivity(i)
        }

        var routeActivity = RouteActivity()
        routeActivity.mrkr

        var clickedPin = intent.getStringExtra("value")

        println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
        println(clickedPin)

        if(clickedPin == "1") {
            Toast.makeText(applicationContext,"YEEEES",Toast.LENGTH_SHORT).show()
            println("jjssssjssjsjjjsjsssssssssssAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
        }

        /*
        when(clickedPin) {
            1 -> Toast.makeText(applicationContext,"YEEEES",Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(applicationContext,"NO PLZ",Toast.LENGTH_SHORT).show()
        }
        */
    }
}