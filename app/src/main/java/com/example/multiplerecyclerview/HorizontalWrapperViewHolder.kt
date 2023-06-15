package com.example.multiplerecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.multiplerecyclerview.databinding.ItemHorizontalWrapperBinding

class HorizontalWrapperViewHolder(
    private val binding: ItemHorizontalWrapperBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(adapter: HorizontalAdapter) {
        binding.recyclerview.adapter = adapter
    }
}
