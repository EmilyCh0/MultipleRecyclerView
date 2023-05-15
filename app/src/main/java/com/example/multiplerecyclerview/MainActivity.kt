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

        val horizontalItems = List(10) { Item("H${it}") }
        binding.horizontalRecyclerview.adapter = HorizontalAdapter(horizontalItems)

        val verticalGridItems = List(20) { Item("VG${it}") }
        binding.verticalGridRecyclerview.adapter = VerticalGridAdapter(verticalGridItems)
    }
}
