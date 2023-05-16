package com.example.multiplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multiplerecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val horizontalHorizontalItems = List(10) { HorizontalItem("H${it}") }
        binding.horizontalRecyclerview.adapter = HorizontalAdapter(horizontalHorizontalItems)

        val verticalGridHorizontalItems = List(20) { VerticalGridItem("VG${it}") }
        binding.verticalGridRecyclerview.adapter = VerticalGridAdapter(verticalGridHorizontalItems)
    }
}
