package com.example.purelywed.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.purelywed.databinding.ItemLayoutBinding
import com.example.purelywed.model.CardItem

class Adapter(
    private val items: List<CardItem>,
    private val onItemClick: (CardItem) -> Unit // click listener
) : RecyclerView.Adapter<Adapter.CardViewHolder>() {

    inner class CardViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CardItem) {
            binding.text.text = item.text
            binding.image.setImageResource(item.imageRes)

            // handle clicks on the whole card
            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
