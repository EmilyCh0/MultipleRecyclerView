package com.example.multiplerecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplerecyclerview.databinding.ItemHorizontalBinding

class HorizontalAdapter(
    private val items: List<HorizontalItem>
) : RecyclerView.Adapter<HorizontalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val binding = ItemHorizontalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HorizontalViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
