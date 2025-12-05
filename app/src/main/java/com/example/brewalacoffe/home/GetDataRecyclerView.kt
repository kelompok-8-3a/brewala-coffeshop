package com.example.brewalacoffe.home

import android.content.Intent
import com.example.brewalacoffe.Menu
import com.example.brewalacoffe.Promo
import com.example.brewalacoffe.R
import com.example.brewalacoffe.TypePromo

class GetDataRecyclerView {
    fun getDataListCategory(): List<Category>

    fun getDataListMenu(): List<Menu>{
        val listMenu = mutableListOf<Menu>()

        listMenu.add(Menu(
            R.drawable.item_menu_capuccino,
            "Capuccino",
            "Sajian kopi klasik yang menggabungkan espresso berkualitas tinggi dengan susu panas bertekstur lembut, dilengkapi lapisan foam halus sebagai penutup.",
            20000,
            CategoryMenu.EXPRESSO_BASED))

        listMenu.add(Menu(
            R.drawable.item_menu_caffe_latte,
            "Caffe Latte",
            "",
            18000,
            CategoryMenu.EXPRESSO_BASED))

        listMenu.add(Menu(
            R.drawable.item_menu_americano,
            "Iced Americano",
            "",
            15000,
            CategoryMenu.COLD_CAFFE))
        listMenu.add(Menu(
            R.drawable.item_menu_caramel_latte,
            "Caramel Latte",
            "",
            22000,
            CategoryMenu.FLAVORED))

        return listMenu
    }

    fun getDataListPromo(): List<Promo> {
        val listPromo = mutableListOf<Promo>()

        listPromo.add(Promo(
            TypePromo.NEW_MEMBER,
            "Discount 10% untuk morning person",
            R.drawable.banner_discount
        ))

        listPromo.add(Promo(
            TypePromo.DISCOUNT,
            "Discount beli 1 gratis 1 untuk morning person",
            R.drawable.banner_discount
        ))

        listPromo.add(Promo(
            TypePromo.NEW_MEMBER,
            "Discount 10% untuk morning person",
            R.drawable.banner_discount
        ))

        return listPromo
    }

}