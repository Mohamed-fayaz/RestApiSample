package com.example.jokesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jokesapp.databinding.ListrvitemBinding

class JokeRvAdapter (): ListAdapter<JokesProperty, JokeRvAdapter.JokesPropertyViewHolder>(DiffCallback) {
    object DiffCallback : DiffUtil.ItemCallback<JokesProperty>(){
        override fun areItemsTheSame(oldItem: JokesProperty, newItem: JokesProperty): Boolean {
           return oldItem ==newItem
        }

        override fun areContentsTheSame(oldItem: JokesProperty, newItem: JokesProperty): Boolean {
          return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeRvAdapter.JokesPropertyViewHolder {
        return JokesPropertyViewHolder(ListrvitemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: JokeRvAdapter.JokesPropertyViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)


    }
    class JokesPropertyViewHolder(private var binding: ListrvitemBinding):

        RecyclerView.ViewHolder(binding.root) {
        fun bind(jokesProperty: JokesProperty) {
            binding.property = jokesProperty
            binding.executePendingBindings()
        }
    }


}