package com.example.multiplerecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplerecyclerview.databinding.ItemVerticalGridBinding

class VerticalGridAdapter(
    private val items: List<Item>
) : RecyclerView.Adapter<VerticalGridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalGridViewHolder {
        val binding = ItemVerticalGridBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VerticalGridViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VerticalGridViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
