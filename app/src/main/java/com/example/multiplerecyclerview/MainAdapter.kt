package com.example.multiplerecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplerecyclerview.databinding.ItemHorizontalWrapperBinding
import com.example.multiplerecyclerview.databinding.ItemVerticalGridBinding

class MainAdapter(
    private val items: List<MainItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (MainViewType.values()[viewType]) {
            MainViewType.HORIZONTAL -> {
                val binding = ItemHorizontalWrapperBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                HorizontalWrapperViewHolder(binding)
            }

            MainViewType.VERTICAL_GRID -> {
                val binding = ItemVerticalGridBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                VerticalGridViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is HorizontalWrapperViewHolder -> holder.bind(HorizontalAdapter(item as MainItem.HorizontalItems))
            is VerticalGridViewHolder -> holder.bind(item as MainItem.VerticalGridItem)
        }
    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is MainItem.HorizontalItems -> MainViewType.HORIZONTAL.ordinal
        is MainItem.VerticalGridItem -> MainViewType.VERTICAL_GRID.ordinal
    }

    override fun getItemCount(): Int = items.size
}
