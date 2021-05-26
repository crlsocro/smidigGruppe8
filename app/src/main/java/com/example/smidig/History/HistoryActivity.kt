package com.example.smidig.History

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smidig.*
import com.example.smidig.databinding.ActivityHistoryBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class HistoryActivity : AppCompatActivity(){

    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                return@OnNavigationItemSelectedListener false
            }
            R.id.homepage -> {
                val intent = Intent(this@HistoryActivity, MapsActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@HistoryActivity,HistoryActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                val intent = Intent(this@HistoryActivity, ProfileActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    private var listAdapter = HistoryAdapter(ArrayList<HistoryStats>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation7)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)

        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, SigninActivity::class.java)
            startActivity(i)
        }

        binding.historyRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.historyRecyclerView.adapter = listAdapter
        listAdapter.update(HistoryDummy().getHistory())

        var infoBtn = findViewById<ImageView>(R.id.infoIcon)
        infoBtn.setOnClickListener{
            val popUp = PopupMenu(this, infoBtn)
            val popUpToast = Toast.makeText(applicationContext, "I en historie følger du en \n " +
                    "tilrettelagt rute som er \n " +
                    "tiltenkt å følges kronologisk", Toast.LENGTH_SHORT).show()
        }
    }
}