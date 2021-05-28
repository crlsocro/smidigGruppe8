package com.example.smidig

import android.content.ClipData
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.*
import com.example.smidig.History.HistoryActivity
import com.example.smidig.History.Info
import com.example.smidig.History.InfoConstants
import com.example.smidig.quiz.Constants
import com.example.smidig.quiz.Questions
import com.example.smidig.quiz.QuizActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class PostActivity : AppCompatActivity() {

    lateinit var runnable: Runnable
    private var handler = Handler()
    private var mCurrentP: Int = 1
    private var currentIList: ArrayList<Info>? = null
    private var selectedOption: Int = 0

    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                return@OnNavigationItemSelectedListener false
            }
            R.id.homepage -> {
                val intent = Intent(this@PostActivity, MapsActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@PostActivity, HistoryActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                val intent = Intent(this@PostActivity,  SigninActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        currentIList = InfoConstants.getInfo()
        setInfo()
        var completeBtn = findViewById<ImageView>(R.id.buttonBG)
        completeBtn.setOnClickListener {
            val i = Intent(this, QuizActivity::class.java)
            var clickedPin = intent.getStringExtra("value")
            i.putExtra("value", clickedPin)
            startActivity(i)
        }
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)

        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, RouteActivity::class.java)
            startActivity(i)
        }

        //TODO: rydde i dette rotet, lagt til for å adde forskjellig post text


        //Inspired by https://www.youtube.com/watch?v=DaLPIC4NbYU&ab_channel=doctorcode

        val mediaPlayer = MediaPlayer.create(this, R.raw.example1)
        var seekBar = findViewById<SeekBar>(R.id.seekBar)
        seekBar.progress = 0
        seekBar.max = mediaPlayer.duration
        val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        var back = findViewById<ImageView>(R.id.backward)
        var forward = findViewById<ImageView>(R.id.forward)
        var play = findViewById<ImageView>(R.id.play)
        play.setOnClickListener {

            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                play.setImageResource(R.drawable.ic_baseline_pause_24)
            } else {
                mediaPlayer.pause()
                play.setImageResource(R.drawable.ic_action_play)
            }
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        runnable = Runnable {
            seekBar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
        mediaPlayer.setOnCompletionListener {
            play.setImageResource(R.drawable.ic_action_play)
            seekBar.progress = 0
        }
    }

    private fun setInfo() {
        mCurrentP = 1
        val info = currentIList!![mCurrentP - 1]
        val infoText = findViewById<TextView>(R.id.postParapraghText)
        val title = findViewById<TextView>(R.id.postText)

        var clickedPin = intent?.getStringExtra("value")
        when (clickedPin) {
            "1" -> {
                mCurrentP = 1
                val info = currentIList!![mCurrentP - 1]
                infoText.text = info!!.info
                title.text = info?.title
            }
            "2" -> {
                mCurrentP = 2
                val info2 = currentIList!![mCurrentP - 1]
                infoText.text = info2!!.info
                title.text = info2?.title
            }
            "3" -> {
                mCurrentP = 3
                val info3 = currentIList!![mCurrentP - 1]
                infoText.text = info3!!.info
                title.text = info3?.title
            }
            "4" -> {
                mCurrentP = 4
                val info4 = currentIList!![mCurrentP - 1]
                infoText.text = info4!!.info
                title.text = info4?.title
            }
            "5" -> {
                mCurrentP = 5
                val info5 = currentIList!![mCurrentP - 1]
                infoText.text = info5!!.info
                title.text = info5?.title
            }
            "6" -> {
                mCurrentP = 1
                val info = currentIList!![mCurrentP - 1]
                infoText.text = info!!.info
                title.text = info?.title
            }
            "7" -> {
                mCurrentP = 2
                val info2 = currentIList!![mCurrentP - 1]
                infoText.text = info2!!.info
                title.text = info2?.title
            }
            "8" -> {
                mCurrentP = 3
                val info3 = currentIList!![mCurrentP - 1]
                infoText.text = info3!!.info
                title.text = info3?.title
            }
            "9" -> {
                mCurrentP = 4
                val info4 = currentIList!![mCurrentP - 1]
                infoText.text = info4!!.info
                title.text = info4?.title
            }
            "10" -> {
                mCurrentP = 5
                val info5 = currentIList!![mCurrentP - 1]
                infoText.text = info5!!.info
                title.text = info5?.title
            }

            //Inspired by https://www.youtube.com/watch?v=DaLPIC4NbYU&ab_channel=doctorcode
        }
    }
}

