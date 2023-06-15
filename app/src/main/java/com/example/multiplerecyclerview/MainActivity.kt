package com.example.multiplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.multiplerecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val horizontalItems = List(10) { HorizontalItem("H${it}") }
        val horizontalAdapter = HorizontalAdapter(horizontalItems)

        val horizontalWrapperAdapter = HorizontalWrapperAdapter(horizontalAdapter)

        val verticalGridItems = List(20) { VerticalGridItem("VG${it}") }
        val verticalGridAdapter = VerticalGridAdapter(verticalGridItems)

        val config = ConcatAdapter.Config.Builder().apply {
            setIsolateViewTypes(false)
        }.build()
        val concatAdapter = ConcatAdapter(config, horizontalWrapperAdapter, verticalGridAdapter)

        val layoutManager = GridLayoutManager(this, 2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (concatAdapter.getItemViewType(position)) {
                    HorizontalWrapperAdapter.VIEW_TYPE -> 2
                    VerticalGridAdapter.VIEW_TYPE -> 1
                    else -> 2
                }
            }
        }

        binding.concatRecyclerview.adapter = concatAdapter
        binding.concatRecyclerview.layoutManager = layoutManager
    }
}
