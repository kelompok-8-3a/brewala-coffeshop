package com.example.brewalacoffe.home

import com.example.brewalacoffe.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brewalacoffe.Menu

class MenuAdapter(
    val listMenu: List<Menu>,
    val onClickItemMenu: (Menu) -> Unit):
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuViewHolder {
        val layout: View = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_menu,
                parent,
                false)

        return MenuViewHolder(layout)
    }

    override fun onBindViewHolder(
        holder: MenuViewHolder,
        position: Int
    ) {
        val menu: Menu = listMenu.get(position)

        holder.row.setOnClickListener {
            onClickItemMenu(menu)
        }

        holder.textViewNameMenu.text = menu.nameMenu
        holder.textViewPriceMenu.text = menu.priceMenu.toString()
        holder.imageViewMenu.setImageResource(menu.imageMenu)
    }

    override fun getItemCount(): Int = listMenu.size

    class MenuViewHolder(val row: View) : RecyclerView.ViewHolder(row){
        val imageViewMenu = row.findViewById<ImageView>(R.id.imageViewImageMenu)
        val textViewNameMenu = row.findViewById<TextView>(R.id.textViewNameMenu)
        val textViewPriceMenu: TextView = row.findViewById<TextView>(R.id.textViewPriceMenu)
    }

}