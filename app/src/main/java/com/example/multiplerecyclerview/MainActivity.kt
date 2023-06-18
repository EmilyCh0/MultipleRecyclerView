package com.example.multiplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.multiplerecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val horizontalItems: MainItem = MainItem.HorizontalItems(
            List(10) { HorizontalItem("H${it}") }
        )

        val verticalGridItems: List<MainItem> = List(20) { MainItem.VerticalGridItem("VG${it}") }

        val items: List<MainItem> = listOf(horizontalItems) + verticalGridItems

        val mainAdapter = MainAdapter(items)

        val gridLayoutManager = GridLayoutManager(this, 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (mainAdapter.getItemViewType(position)) {
                    MainViewType.HORIZONTAL.ordinal -> 2
                    MainViewType.VERTICAL_GRID.ordinal -> 1
                    else -> 2
                }
            }
        }

        binding.mainRecyclerview.layoutManager = gridLayoutManager
        binding.mainRecyclerview.adapter = mainAdapter
    }
}
