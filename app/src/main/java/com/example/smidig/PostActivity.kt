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
import com.example.smidig.quiz.QuizActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class PostActivity : AppCompatActivity() {

    lateinit var runnable: Runnable
    private var handler = Handler()

    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                return@OnNavigationItemSelectedListener false
            }
            R.id.homepage -> {
                val intent = Intent(this@PostActivity, SigninActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@PostActivity, HistoryActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

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
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)

        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, RouteActivity::class.java)
            startActivity(i)
        }

        var clickedPin = intent?.getStringExtra("markerValue")

        if(clickedPin == "1") {
            println("dette er post 1")
        } else if (clickedPin == "2") {
            println("dette er påsssst 2")
        }

        //Inspired by https://www.youtube.com/watch?v=DaLPIC4NbYU&ab_channel=doctorcode

        val mediaPlayer = MediaPlayer.create(this, R.raw.example1)
        var seekBar = findViewById<SeekBar>(R.id.seekBar)
        seekBar.progress = 0
        seekBar.max = mediaPlayer.duration
        val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        var back = findViewById<ImageView>(R.id.backward)
        var forward = findViewById<ImageView>(R.id.forward)
        var play = findViewById<ImageView>(R.id.play)
        play.setOnClickListener{

            if(!mediaPlayer.isPlaying){
                mediaPlayer.start()
                play.setImageResource(R.drawable.ic_baseline_pause_24)
            }else{
                mediaPlayer.pause()
                play.setImageResource(R.drawable.ic_action_play)
            }
        }
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
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

}