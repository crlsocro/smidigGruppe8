package com.example.smidig.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.smidig.*
import com.example.smidig.History.HistoryActivity
import com.example.smidig.database.MarkerDao
import com.example.smidig.database.MultiDatabase
import com.example.smidig.database.Quiz
import com.example.smidig.database.QuizDao
import com.google.android.material.bottomnavigation.BottomNavigationView


class QuizActivity: AppCompatActivity() {


    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                return@OnNavigationItemSelectedListener false
            }
            R.id.homepage -> {
                val intent = Intent(this@QuizActivity, SigninActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@QuizActivity, HistoryActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    private var mCurrentP: Int = 1
    private var currentQList: ArrayList<Questions>? = null
    private var selectedOption: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizpage)
        supportActionBar?.hide()
        currentQList = Constants.getQuestions()
        setQuestion()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation5)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)
        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, PostActivity::class.java)
            startActivity(i)
        }

        val clickedPin = intent.getStringExtra("value")
        if(clickedPin == "1") {
            println("Dette er quiz 1")
        } else if(clickedPin == "2") {
            println("Dette er quiz 2")
        } else if(clickedPin == "3") {
            println("Dette er quiz 3")
        } else if(clickedPin == "4") {
            println("Dette er quiz 4")
        } else if(clickedPin == "5") {
            println("Dette er quiz 5")
        }


    }

    private fun setQuestion() {
        mCurrentP = 1
        val question = currentQList!![mCurrentP - 1]
        val questionView = findViewById<TextView>(R.id.question)
        val optionOne = findViewById<TextView>(R.id.option_one)
        val optionTwo = findViewById<TextView>(R.id.option_two)
        val optionThree = findViewById<TextView>(R.id.option_three)
        val optionFour = findViewById<TextView>(R.id.option_four)

        //var radioButton = findViewById<RadioGroup>(R.id.radioGroup)
       var radioButton1 = findViewById<RadioButton>(R.id.option_one)
       var radioButton2 = findViewById<RadioButton>(R.id.option_two)
       var radioButton3 = findViewById<RadioButton>(R.id.option_three)
       var radioButton4 = findViewById<RadioButton>(R.id.option_four)

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

            var markerDao : MarkerDao = MultiDatabase.get(this).getMDao()
            var quizDAO : QuizDao = MultiDatabase.get(this).getQDao()

            var quizTest : Quiz = Quiz(0, "Test", "test","test")
            quizDAO.addQuiz(quizTest)

            var test : Quiz = quizDAO.getQuizWithQuizId(1)
            println("test = " + test)
            println("test.size")

            var check = 0

            for (i in 1..5) {
                if(markerDao.getMarker(i).clicked) {
                   check += 1
                } else {
                    println(":(")
                }

                if(check == 5) {
                    for (i in 1..5) {
                        markerDao.setClicked(i, 0)
                    }
                    val i = Intent(this, SummaryActivity::class.java)
                    startActivity(i)
                } else {
                    println(check)
                    println("check")
                    val i = Intent(this, RouteActivity::class.java)
                    startActivity(i)
                }
            }

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