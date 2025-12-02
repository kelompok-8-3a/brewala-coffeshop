package com.example.brewalacoffe.home

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recylerviewProduct = view.findViewById<RecyclerView>(R.id.recyclerviewListMenu)
        recylerviewProduct.layoutManager = LinearLayoutManager(requireActivity())

        val listMenu:List<Menu> = getData()

        recylerviewProduct.adapter = MenuAdapter(
            listMenu
        )


    }

    fun getData(): List<Menu>{
        val listMenu = mutableListOf<Menu>()

        listMenu.add(Menu(
            "Capuccino",
            "Sajian kopi klasik yang menggabungkan espresso berkualitas tinggi dengan susu panas bertekstur lembut, dilengkapi lapisan foam halus sebagai penutup.",
            20000,
            CategoryMenu.EXPRESSO_BASED))

        listMenu.add(Menu(
            "Caffe Latte",
            "",
            18000,
            CategoryMenu.EXPRESSO_BASED))

        listMenu.add(Menu(
            "Iced Americano",
            "",
            15000,
            CategoryMenu.COLD_CAFFE))
        listMenu.add(Menu(
            "Caramel Latte",
            "",
            22000,
            CategoryMenu.FLAVORED))

        return listMenu
    }

}