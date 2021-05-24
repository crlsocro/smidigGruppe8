package com.example.smidig.quiz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smidig.databinding.ItemQuizViewBinding

class QuizAdapter(private var list: List<Questions>): RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {


    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizAdapter.QuizViewHolder {
        val binding =  ItemQuizViewBinding.inflate(LayoutInflater.from(parent.context))
        return QuizViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuizAdapter.QuizViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class QuizViewHolder(private val binding: ItemQuizViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(stats: Questions){
            binding.textViewOption.text = stats.optionOne
        }

    }


}