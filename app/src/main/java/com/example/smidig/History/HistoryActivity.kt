package com.example.smidig.History

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smidig.R
import com.example.smidig.databinding.ActivityHistoryBinding


class HistoryActivity : AppCompatActivity(){

    private var listAdapter = HistoryAdapter(ArrayList<HistoryStats>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

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