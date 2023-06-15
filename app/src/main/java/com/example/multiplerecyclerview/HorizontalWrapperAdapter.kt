package com.example.multiplerecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplerecyclerview.databinding.ItemHorizontalWrapperBinding

class HorizontalWrapperAdapter(
    private val adapter: HorizontalAdapter
) : RecyclerView.Adapter<HorizontalWrapperViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalWrapperViewHolder {
        return HorizontalWrapperViewHolder(
            ItemHorizontalWrapperBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: HorizontalWrapperViewHolder, position: Int) {
        holder.bind(adapter)
    }

    override fun getItemViewType(position: Int): Int = VIEW_TYPE

    companion object {
        const val VIEW_TYPE = 111
    }
}
