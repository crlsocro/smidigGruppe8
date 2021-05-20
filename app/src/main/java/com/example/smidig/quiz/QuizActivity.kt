package com.example.smidig.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smidig.R
import com.example.smidig.RouteActivity
import com.example.smidig.SummaryActivity


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
            val i = Intent(this, RouteActivity::class.java)
            var clickedPin = intent.getStringExtra("markerValue")
            i.putExtra("markerValue", clickedPin)
            startActivity(i)
            println(clickedPin)
        }
    }
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.option_one ->
                    if (checked) {
                        selectedOption = 0
                    }
                R.id.option_two ->
                    if (checked) {
                        selectedOption = 1
                    }
                R.id.option_three ->
                    if (checked) {
                        selectedOption = 2
                    }
                R.id.option_four ->
                    if (checked) {
                        selectedOption = 3
                    }
            }
        }
    }
}

//https://www.youtube.com/watch?v=b21fiIyOW4A&t=4064s&ab_channel=tutorialsEU