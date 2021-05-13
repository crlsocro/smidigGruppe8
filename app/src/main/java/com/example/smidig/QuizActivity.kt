package com.example.smidig

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizActivity: AppCompatActivity() {

    private var mCurrentP: Int = 1
    private var currentQList: ArrayList<Questions>? = null
    private var selectedOption: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizpage)
        supportActionBar?.hide()
        currentQList = Constants.getQuestions()
        setQuestion()

    }
    private fun setQuestion() {
        mCurrentP = 1
        val question = currentQList!![mCurrentP - 1]
        val questionView = findViewById<TextView>(R.id.question)
        val optionOne = findViewById<TextView>(R.id.option_one)
        val optionTwo = findViewById<TextView>(R.id.option_two)
        val optionThree = findViewById<TextView>(R.id.option_three)
        val optionFour = findViewById<TextView>(R.id.option_four)

        questionView.text = question!!.question
        optionOne.text = question?.optionOne
        optionTwo.text = question?.optionTwo
        optionThree.text = question?.optionThree
        optionFour.text = question?.optionFour

        /*optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)*/

        var submitBtn = findViewById<Button>(R.id.submitBtn)
        submitBtn.setOnClickListener {
            val i = Intent(this, MapsActivity::class.java)
            startActivity(i)
        }
    }

}

//https://www.youtube.com/watch?v=b21fiIyOW4A&t=4064s&ab_channel=tutorialsEU