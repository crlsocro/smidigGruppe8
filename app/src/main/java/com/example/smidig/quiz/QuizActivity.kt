package com.example.smidig.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.smidig.*
import com.example.smidig.History.HistoryActivity
import com.example.smidig.History.HistoryRouteActivity
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

        var infoBtn = findViewById<ImageView>(R.id.infoIcon)
        infoBtn.setOnClickListener{
            val popUp = PopupMenu(this, infoBtn)
            val popUpToast = Toast.makeText(applicationContext,
                "Klarer du å få alle riktig? \n",
                Toast.LENGTH_SHORT).show()
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

        /*optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)*/


        val clickedPin = intent.getStringExtra("value")
        when (clickedPin) {
            "1" -> {
                mCurrentP = 1
                val question = currentQList!![mCurrentP - 1]
                questionView.text = question!!.question
                optionOne.text = question?.optionOne
                optionTwo.text = question?.optionTwo
                optionThree.text = question?.optionThree
                optionFour.text = question?.optionFour
            }
            "2" -> {
                mCurrentP = 2
                val question2 = currentQList!![mCurrentP - 1]
                questionView.text = question2!!.question
                optionOne.text = question2?.optionOne
                optionTwo.text = question2?.optionTwo
                optionThree.text = question2?.optionThree
                optionFour.text = question2?.optionFour
            }
            "3" -> {
                mCurrentP = 3
                val question3 = currentQList!![mCurrentP - 1]
                questionView.text = question3!!.question
                optionOne.text = question3?.optionOne
                optionTwo.text = question3?.optionTwo
                optionThree.text = question3?.optionThree
                optionFour.text = question3?.optionFour
            }
            "4" -> {
                mCurrentP = 4
                val question4 = currentQList!![mCurrentP - 1]
                questionView.text = question4!!.question
                optionOne.text = question4?.optionOne
                optionTwo.text = question4?.optionTwo
                optionThree.text = question4?.optionThree
                optionFour.text = question4?.optionFour
            }
            "5" -> {
                mCurrentP = 5
                val question5 = currentQList!![mCurrentP - 1]
                questionView.text = question5!!.question
                optionOne.text = question5?.optionOne
                optionTwo.text = question5?.optionTwo
                optionThree.text = question5?.optionThree
                optionFour.text = question5?.optionFour
            }
            "6" -> {
                mCurrentP = 1
                val question = currentQList!![mCurrentP - 1]
                questionView.text = question!!.question
                optionOne.text = question?.optionOne
                optionTwo.text = question?.optionTwo
                optionThree.text = question?.optionThree
                optionFour.text = question?.optionFour
            }
            "7" -> {
                mCurrentP = 2
                val question2 = currentQList!![mCurrentP - 1]
                questionView.text = question2!!.question
                optionOne.text = question2?.optionOne
                optionTwo.text = question2?.optionTwo
                optionThree.text = question2?.optionThree
                optionFour.text = question2?.optionFour
            }
            "8" -> {
                mCurrentP = 3
                val question3 = currentQList!![mCurrentP - 1]
                questionView.text = question3!!.question
                optionOne.text = question3?.optionOne
                optionTwo.text = question3?.optionTwo
                optionThree.text = question3?.optionThree
                optionFour.text = question3?.optionFour
            }
            "9" -> {
                mCurrentP = 4
                val question4 = currentQList!![mCurrentP - 1]
                questionView.text = question4!!.question
                optionOne.text = question4?.optionOne
                optionTwo.text = question4?.optionTwo
                optionThree.text = question4?.optionThree
                optionFour.text = question4?.optionFour
            }
            "10" -> {
                mCurrentP = 5
                val question5 = currentQList!![mCurrentP - 1]
                questionView.text = question5!!.question
                optionOne.text = question5?.optionOne
                optionTwo.text = question5?.optionTwo
                optionThree.text = question5?.optionThree
                optionFour.text = question5?.optionFour
            }
        }

        var submitBtn = findViewById<Button>(R.id.submitBtn)
        submitBtn.setOnClickListener {

            var markerDao : MarkerDao = MultiDatabase.get(this).getMDao()
            /*
            var quizDAO : QuizDao = MultiDatabase.get(this).getQDao()

            var quizTest : Quiz = Quiz(0, "Test", "test","test")
            quizDAO.addQuiz(quizTest)

            var test : Quiz = quizDAO.getQuizWithQuizId(1)
            println("test = " + test)
            println("test.size")*/

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
                } else if(clickedPin?.toInt() == 10) {
                    for (i in 6..10) {
                        markerDao.setClicked(i, 0)
                    }
                    val i = Intent(this, SummaryActivity::class.java)
                    startActivity(i)
                } else {
                    if(clickedPin?.toInt()!! <= 5) {
                        println(check)
                        println("check")
                        val i = Intent(this, RouteActivity::class.java)
                        startActivity(i)
                    } else {
                        val i = Intent(this, HistoryRouteActivity::class.java)
                        startActivity(i)
                    }
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