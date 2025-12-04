package com.example.brewalacoffe.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brewalacoffe.CategoryMenu
import com.example.brewalacoffe.Menu
import com.example.brewalacoffe.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recylerviewProduct = view.findViewById<RecyclerView>(R.id.recyclerviewListMenu)
        recylerviewProduct.layoutManager = LinearLayoutManager(requireActivity())

        val listMenu:List<Menu> = getData()

        recylerviewProduct.adapter = MenuAdapter(
            listMenu,
            ::goToProduct
        )

    }

    fun goToProduct(menu:Menu): Unit{
        val detailProductIntent = Intent(
            requireActivity(),
            DetailProductActivity::class.java,
        )


//        detailProductIntent.putExtra("menu", List<Menu>(menu))
        detailProductIntent.putExtra(IMAGE_PRODUCT, menu.imageMenu)
        detailProductIntent.putExtra(PRICE_PRODUCT, menu.priceMenu)
        detailProductIntent.putExtra(NAME_PRODUCT, menu.nameMenu)
        detailProductIntent.putExtra(CATEGORY_PRODUCT, menu.categoryMenu)
        detailProductIntent.putExtra(DESCRIBE_PRODUCT, menu.describeMenu)


        startActivity(detailProductIntent)

    }

    fun getData(): List<Menu>{
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

    companion object {
        const val NAME_PRODUCT = "name_product"
        const val PRICE_PRODUCT = "price_product"
        const val IMAGE_PRODUCT = "image_product"
        const val CATEGORY_PRODUCT = "category_prodcut"
        const val  DESCRIBE_PRODUCT = "describe_product"
    }

}