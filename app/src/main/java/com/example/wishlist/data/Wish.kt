package com.example.wishlist.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyWish{
    val wishlist = listOf(
        Wish(1, "Title 1", "Description 1"),
        Wish(2, "Title 2", "Description 2"),
        Wish(3, "Title 3", "Description 3"),
        Wish(4, "Title 4", "Description 4"),
        Wish(5, "Title 5", "Description 5"),
    )
}