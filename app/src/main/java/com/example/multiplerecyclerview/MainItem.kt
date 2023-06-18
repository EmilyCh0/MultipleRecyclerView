package com.example.multiplerecyclerview

sealed interface MainItem {
    data class HorizontalItems(val items: List<HorizontalItem>) : MainItem
    data class VerticalGridItem(val title: String) : MainItem
}
