package com.example.smidig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
    }
}