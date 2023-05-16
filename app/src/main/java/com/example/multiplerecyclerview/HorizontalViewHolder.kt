package com.example.multiplerecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.multiplerecyclerview.databinding.ItemHorizontalBinding

class HorizontalViewHolder(
    private val binding: ItemHorizontalBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: HorizontalItem) {
        binding.title.text = item.title
    }
}
