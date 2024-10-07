package com.turing.alan.cpifp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.turing.alan.cpifp.data.Champion
import com.turing.alan.cpifp.databinding.CampeonListItemBinding

class CampeonesListAdapter(): ListAdapter<Champion, CampeonesListAdapter.ChampionViewHolder>(ChampionDiffCallback) {
    //ViewHolder: puente entre el xml y la informacion que tenemos
    //inner: todos sus propiedades son visibles para la padre
    class ChampionViewHolder(private val binding: CampeonListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(champion: Champion){
            binding.winName.text=champion.name
            binding.title.text= champion.title
            binding.loren.text=champion.lore
            binding.img.load(champion.imageUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder {
        //intanciamos el xml y lo pasamos al itemViewHolder
        val binding: CampeonListItemBinding = CampeonListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChampionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    object ChampionDiffCallback: DiffUtil.ItemCallback<Champion>(){
        override fun areItemsTheSame(oldItem: Champion,newItem: Champion) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Champion,newItem: Champion) =
                oldItem.name == newItem.name &&
                oldItem.title == newItem.title &&
                oldItem.lore == newItem.lore &&
                oldItem.imageUrl == newItem.imageUrl
    }
}

