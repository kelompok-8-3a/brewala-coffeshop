package com.example.brewalacoffe.home

import android.content.Intent
import com.example.brewalacoffe.Menu
import com.example.brewalacoffe.Promo
import com.example.brewalacoffe.R
import com.example.brewalacoffe.TypePromo

class GetDataRecyclerView {
    fun getDataListCategory(): List<CategoryMenu>{
        val listCategory = mutableListOf<CategoryMenu>()

        listCategory.add(CategoryMenu.ALL)
        listCategory.add(CategoryMenu.EXPRESSO_BASED)
        listCategory.add(CategoryMenu.COLD_CAFFE)
        listCategory.add(CategoryMenu.FLAVORED)
        listCategory.add(CategoryMenu.AMERICANO)
        listCategory.add(CategoryMenu.CAPUCCINO)
        listCategory.add(CategoryMenu.LATTE)

        return listCategory
    }

    fun getDataListMenu(): MutableList<Menu>{
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

        listMenu.add(
            Menu(
                R.drawable.item_menu_mocha,
                "Iced Mocha",
                "Kombinasi espresso, cokelat, dan susu disajikan dengan es.",
                23000,
                CategoryMenu.COLD_CAFFE
            )
        )

        listMenu.add(
            Menu(
                R.drawable.item_menu_capuccino,
                "Iced Cappuccino",
                "Cappuccino versi dingin dengan rasa creamy dan segar.",
                22000,
                CategoryMenu.CAPUCCINO
            )
        )

        // =======================
        // LATTE CATEGORY
        // =======================
        listMenu.add(
            Menu(
                R.drawable.item_menu_caffe_latte,
                "Caffe Latte",
                "Espresso creamy dengan steamed milk lembut.",
                18000,
                CategoryMenu.LATTE
            )
        )

        listMenu.add(
            Menu(
                R.drawable.item_menu_matcha_latte,
                "Matcha Latte",
                "Teh matcha premium dengan susu, rasa earthy dan creamy.",
                25000,
                CategoryMenu.LATTE
            )
        )

        listMenu.add(
            Menu(
                R.drawable.item_menu_vanilla_latte,
                "Vanilla Latte",
                "Latte lembut dengan sirup vanila manis dan aromatik.",
                23000,
                CategoryMenu.LATTE
            )
        )

        // =======================
        // AMERICANO CATEGORY
        // =======================
        listMenu.add(
            Menu(
                R.drawable.item_menu_americano,
                "Americano",
                "Espresso dengan tambahan air panas, rasa ringan dan bold.",
                15000,
                CategoryMenu.AMERICANO
            )
        )

        listMenu.add(
            Menu(
                R.drawable.item_menu_ice_americano,
                "Iced Americano",
                "Americano versi dingin, lebih segar dan ringan.",
                16000,
                CategoryMenu.AMERICANO
            )
        )

        listMenu.add(
            Menu(
                R.drawable.item_menu_long_black,
                "Long Black",
                "Mirip Americano namun espresso dituangkan ke air panas.",
                17000,
                CategoryMenu.AMERICANO
            )
        )

        // =======================
        // EXPRESSO BASED
        // =======================
        listMenu.add(
            Menu(
                R.drawable.item_menu_espresso,
                "Single Espresso",
                "Kopi hitam pekat dan strong.",
                12000,
                CategoryMenu.EXPRESSO_BASED
            )
        )

        listMenu.add(
            Menu(
                R.drawable.item_menu_double_espresso,
                "Double Espresso",
                "Dua shot espresso untuk energi ekstra.",
                15000,
                CategoryMenu.EXPRESSO_BASED
            )
        )

        listMenu.add(
            Menu(
                R.drawable.item_menu_macchiato,
                "Espresso Macchiato",
                "Espresso dengan sedikit foam susu.",
                17000,
                CategoryMenu.EXPRESSO_BASED
            )
        )

        // =======================
        // COLD CAFFE
        // =======================
        listMenu.add(
            Menu(
                R.drawable.item_menu_cold_brew,
                "Cold Brew",
                "Kopi diseduh dingin selama 12 jam, rasa smooth dan tidak asam.",
                25000,
                CategoryMenu.COLD_CAFFE
            )
        )

        listMenu.add(
            Menu(
                R.drawable.item_menu_caffe_latte,
                "Iced Latte",
                "Latte dingin lembut dengan es.",
                20000,
                CategoryMenu.COLD_CAFFE
            )
        )

        listMenu.add(
            Menu(
                R.drawable.item_menu_ice_mocha,
                "Iced Mocha",
                "Perpaduan espresso, cokelat, dan susu.",
                23000,
                CategoryMenu.COLD_CAFFE
            )
        )

        // =======================
        // FLAVORED COFFEE
        // =======================
        listMenu.add(
            Menu(
                R.drawable.item_menu_caramel_latte,
                "Caramel Latte",
                "Latte susu creamy dengan sirup karamel.",
                22000,
                CategoryMenu.FLAVORED
            )
        )

        listMenu.add(
            Menu(
                R.drawable.item_menu_hazelnut_latte,
                "Hazelnut Latte",
                "Latte dengan sirup hazelnut manis dan wangi.",
                24000,
                CategoryMenu.FLAVORED
            )
        )

        listMenu.add(
            Menu(
                R.drawable.item_menu_mocha,
                "Mocha Hot",
                "Cokelat panas dengan campuran espresso.",
                25000,
                CategoryMenu.FLAVORED
            )
        )

        listMenu.add(
            Menu(
                R.drawable.item_menu_vanilla_latte,
                "Salted Caramel Coffee",
                "Kopi flavored dengan karamel asin manis.",
                26000,
                CategoryMenu.FLAVORED
            )
        )

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