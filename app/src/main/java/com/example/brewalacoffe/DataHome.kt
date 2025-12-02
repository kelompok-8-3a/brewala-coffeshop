package com.example.brewalacoffe
import android.media.Image
import android.widget.ImageView

data class Menu(
    val imageMenu: Int,
    val nameMenu: String,
    val describeMenu: String,
    val priceMenu: Int,
    val categoryMenu: CategoryMenu,
)

data class CategoryPromo(
    val typePromo: String,
    val describePromo: String,
    val imagePromo: Image,
)

enum class CategoryMenu {
    CAPUCCINO,
    LATTE,
    AMERICANO,
    EXPRESSO_BASED,
    COLD_CAFFE,
    FLAVORED
}
