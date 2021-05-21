package com.example.smidig.History

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smidig.databinding.ItemHistoryViewBinding
import com.squareup.picasso.Picasso

class HistoryAdapter(private var list: List<HistoryStats>): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding =  ItemHistoryViewBinding.inflate(LayoutInflater.from(parent.context))
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class HistoryViewHolder(private val binding: ItemHistoryViewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(stats: HistoryStats){
            binding.textViewName.text = stats.name
            binding.textViewLocation.text = stats.location
            binding.textViewPins.text = stats.numberOfPins.toString()
            binding.root.setOnClickListener{
                val intent = Intent(binding.root.context, InfoActivity::class.java)
                binding.root.context.startActivity(intent)
            }
        }
    }
    fun update(newList: List<HistoryStats>){
        list = newList
        notifyDataSetChanged()
    }

}