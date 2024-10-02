package com.turing.alan.cpifp.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.turing.alan.cpifp.data.Champion
import com.turing.alan.cpifp.databinding.CampeonListItemBinding

class CampeonesListAdapter(): ListAdapter<Champion, CampeonesListAdapter.ChampionViewHolder>(ChampionDiffCallback) {
    class ChampionViewHolder(private val binding: CampeonListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bin(champion: Champion){
            binding.winName.text=champion.name
            binding.title.text= champion.title
            binding.loren.text=champion.lore
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
    object ChampionDiffCallback: DiffUtil.ItemCallback<Champion>(){
        override fun areItemsTheSame(oldItem: Champion,newItem: Champion) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Champion,newItem: Champion) = oldItem.name == newItem.name &&
                oldItem.title == newItem.title &&
                oldItem.lore == newItem.lore
    }
}