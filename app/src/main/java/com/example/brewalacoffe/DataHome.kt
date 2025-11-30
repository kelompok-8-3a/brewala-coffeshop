package com.example.brewalacoffe
import android.media.Image

data class Menu(
    val typeName: String,
    val nameMenu: String,
    val priceMenu: Int,
)

data class CategoryPromo(
    val typePromo: String,
    val describePromo: String,
    val imagePromo: Image,
)
