package com.example.smidig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        supportActionBar?.hide()
    }

    fun toMap(view: View) {
        val intent = Intent(this, MapsActivity::class.java).apply {
        }
        startActivity(intent)
    }
}