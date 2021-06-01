package com.example.smidig.Activities

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.*
import com.example.smidig.Information.Info
import com.example.smidig.Information.InfoConstants
import com.example.smidig.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class PostActivity : AppCompatActivity() {

    lateinit var runnable: Runnable
    private var handler = Handler()
    private var mCurrentP: Int = 1
    private var currentIList: ArrayList<Info>? = null
    private var selectedOption: Int = 0

    //Navigation via footer
    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
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
        //Send information via intent
        var completeBtn = findViewById<ImageView>(R.id.buttonBG)
        completeBtn.setOnClickListener {
            val i = Intent(this, QuizActivity::class.java)
            var clickedPin = intent.getStringExtra("value")
            i.putExtra("value", clickedPin)
            startActivity(i)
        }
        //Onclick
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)
        //Onclick
        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, RouteActivity::class.java)
            startActivity(i)
        }

        //Media player is inspired by https://www.youtube.com/watch?v=DaLPIC4NbYU&ab_channel=doctorcode
        var clickedPin = intent?.getStringExtra("value")
        when (clickedPin) {
            "1" -> {
                val mediaPlayer = MediaPlayer.create(this, R.raw.nonneseter)
                var seekBar = findViewById<SeekBar>(R.id.seekBar)
                seekBar.progress = 0
                seekBar.max = mediaPlayer.duration
                val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
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
            "2" -> {
                val mediaPlayer = MediaPlayer.create(this, R.raw.josephine)
                var seekBar = findViewById<SeekBar>(R.id.seekBar)
                seekBar.progress = 0
                seekBar.max = mediaPlayer.duration
                val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
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
            "3" -> {
                val mediaPlayer = MediaPlayer.create(this, R.raw.vaterland)
                var seekBar = findViewById<SeekBar>(R.id.seekBar)
                seekBar.progress = 0
                seekBar.max = mediaPlayer.duration
                val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
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
            "4" -> {
                val mediaPlayer = MediaPlayer.create(this, R.raw.kolera)
                var seekBar = findViewById<SeekBar>(R.id.seekBar)
                seekBar.progress = 0
                seekBar.max = mediaPlayer.duration
                val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
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
            "5" -> {
                val mediaPlayer = MediaPlayer.create(this, R.raw.ulvehiet)
                var seekBar = findViewById<SeekBar>(R.id.seekBar)
                seekBar.progress = 0
                seekBar.max = mediaPlayer.duration
                val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
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
            "6" -> {
                val mediaPlayer = MediaPlayer.create(this, R.raw.oslo_1000)
                var seekBar = findViewById<SeekBar>(R.id.seekBar)
                seekBar.progress = 0
                seekBar.max = mediaPlayer.duration
                val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
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
            "7" -> {
                val mediaPlayer = MediaPlayer.create(this, R.raw.oslo_middelalderen)
                var seekBar = findViewById<SeekBar>(R.id.seekBar)
                seekBar.progress = 0
                seekBar.max = mediaPlayer.duration
                val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
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
            "8" -> {
                val mediaPlayer = MediaPlayer.create(this, R.raw.oslo_1624)
                var seekBar = findViewById<SeekBar>(R.id.seekBar)
                seekBar.progress = 0
                seekBar.max = mediaPlayer.duration
                val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
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
            "9" -> {
                val mediaPlayer = MediaPlayer.create(this, R.raw.oslo_1700)
                var seekBar = findViewById<SeekBar>(R.id.seekBar)
                seekBar.progress = 0
                seekBar.max = mediaPlayer.duration
                val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
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
            "10" -> {
                val mediaPlayer = MediaPlayer.create(this, R.raw.oslo_1800)
                var seekBar = findViewById<SeekBar>(R.id.seekBar)
                seekBar.progress = 0
                seekBar.max = mediaPlayer.duration
                val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
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
        }

        //Onclick for popup info
        var infoBtn = findViewById<ImageView>(R.id.infoIcon)
        infoBtn.setOnClickListener{
            val popUp = PopupMenu(this, infoBtn)
            val popUpToast = Toast.makeText(applicationContext,
                "Les og/eller hør for å fullføre posten. Husk å stoppe hvis du ikke vil høre mer \n  ",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun setInfo() {
        //Check witch pin is clicked and post the correct info and answers from the InfoConstants object
        mCurrentP = 1
        val info = currentIList!![mCurrentP - 1]
        val infoText = findViewById<TextView>(R.id.postParapraghText)
        val title = findViewById<TextView>(R.id.textView2)
        val image = findViewById<ImageView>(R.id.mapImage)

        var clickedPin = intent?.getStringExtra("value")
        when (clickedPin) {
            "1" -> {
                mCurrentP = 1
                val info = currentIList!![mCurrentP - 1]
                infoText.text = info!!.info
                title.text = info?.title
                image.setImageResource(R.drawable.nonneseter)
            }
            "2" -> {
                mCurrentP = 2
                val info2 = currentIList!![mCurrentP - 1]
                infoText.text = info2!!.info
                title.text = info2?.title
                image.setImageResource(R.drawable.josephine)
            }
            "3" -> {
                mCurrentP = 3
                val info3 = currentIList!![mCurrentP - 1]
                infoText.text = info3!!.info
                title.text = info3?.title
                image.setImageResource(R.drawable.vaterlands)
            }
            "4" -> {
                mCurrentP = 4
                val info4 = currentIList!![mCurrentP - 1]
                infoText.text = info4!!.info
                title.text = info4?.title
                image.setImageResource(R.drawable.toyen)
            }
            "5" -> {
                mCurrentP = 5
                val info5 = currentIList!![mCurrentP - 1]
                infoText.text = info5!!.info
                title.text = info5?.title
                image.setImageResource(R.drawable.ulvehiet)
            }
            "6" -> {
                mCurrentP = 6
                val info6 = currentIList!![mCurrentP - 1]
                infoText.text = info6!!.info
                title.text = info6?.title
                image.setImageResource(R.drawable.oslo1000)

            }
            "7" -> {
                mCurrentP = 7
                val info7 = currentIList!![mCurrentP - 1]
                infoText.text = info7!!.info
                title.text = info7?.title
                image.setImageResource(R.drawable.oslo_middelalderen)
            }
            "8" -> {
                mCurrentP = 8
                val info8 = currentIList!![mCurrentP - 1]
                infoText.text = info8!!.info
                title.text = info8?.title
                image.setImageResource(R.drawable.oslo1624)
            }
            "9" -> {
                mCurrentP = 9
                val info9 = currentIList!![mCurrentP - 1]
                infoText.text = info9!!.info
                title.text = info9?.title
                image.setImageResource(R.drawable.oslo1700)
            }
            "10" -> {
                mCurrentP = 10
                val info10 = currentIList!![mCurrentP - 1]
                infoText.text = info10!!.info
                title.text = info10?.title
                image.setImageResource(R.drawable.oslo1800)
            }
        }
    }
}

