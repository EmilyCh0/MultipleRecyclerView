package com.example.multiplerecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.multiplerecyclerview.databinding.ItemVerticalGridBinding

class VerticalGridViewHolder(
    private val binding: ItemVerticalGridBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MainItem.VerticalGridItem) {
        binding.title.text = item.title
    }
}
