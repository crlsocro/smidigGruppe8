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
            var clickedPin = intent.getStringExtra("markerValue")
            i.putExtra("markerValue", clickedPin)
            startActivity(i)
        }

        var clickedPin = intent?.getStringExtra("markerValue")

        if(clickedPin == "1") {
            println("dette er post 1")
        } else if (clickedPin == "2") {
            println("dette er påsssst 2")
        }

    }

}