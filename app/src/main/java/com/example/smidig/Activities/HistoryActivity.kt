package com.example.smidig.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.RelativeLayout
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.smidig.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class HistoryActivity : AppCompatActivity(){

    //Navigation through screens via footer
    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.homepage -> {
                val intent = Intent(this@HistoryActivity, MapsActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@HistoryActivity, HistoryActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                val intent = Intent(this@HistoryActivity, SigninActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        //Hide standard navigation bar
        supportActionBar?.hide()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation7)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)

        //Header go back button on screen
        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, MapsActivity::class.java)
            startActivity(i)
        }

        //Onclick on image
        var gronlandBtn = findViewById<RelativeLayout>(R.id.scroll1)
        gronlandBtn.setOnClickListener {
            val i = Intent(this, InfoActivity::class.java)
            startActivity(i)
        }

        //Popup with onclick
        var infoBtn = findViewById<ImageView>(R.id.infoIcon)
        infoBtn.setOnClickListener{
            val popUp = PopupMenu(this, infoBtn)
            val popUpToast = Toast.makeText(applicationContext, "I en historie følger du en \n " +
                    "tilrettelagt rute som er \n " +
                    "tiltenkt å følges kronologisk", Toast.LENGTH_SHORT).show()
        }
    }
}