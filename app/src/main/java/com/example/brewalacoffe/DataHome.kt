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

enum class TypePromo {
    NEW_MEMBER,
    DISCOUNT
}

data class Promo(
    val typePromo: TypePromo,
    val describePromo: String,
    val imagePromo: Int,
)

enum class CategoryMenu {
    CAPUCCINO,
    LATTE,
    AMERICANO,
    EXPRESSO_BASED,
    COLD_CAFFE,
    FLAVORED
}
