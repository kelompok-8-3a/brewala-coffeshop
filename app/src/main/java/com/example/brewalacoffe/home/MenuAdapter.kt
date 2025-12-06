package com.example.brewalacoffe.home

import com.example.brewalacoffe.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.brewalacoffe.Menu
import android.content.Intent
import android.os.Bundle
import androidx.navigation.Navigation


class MenuAdapter(
    val listMenu: MutableList<Menu>,
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
        holder.textViewPriceMenu.text = "Rp. " + menu.priceMenu.toString()
        holder.imageViewMenu.setImageResource(menu.imageMenu)
        holder.ImageButtonMenu.visibility = View.VISIBLE
        holder.ImageButtonMenu.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "${menu.nameMenu} ditambahkan",
                Toast.LENGTH_SHORT
            ).show()
            val bundle = Bundle().apply {
                putString("name", menu.nameMenu)
                putInt("price", menu.priceMenu)
                putInt("image", menu.imageMenu)
            }

            Navigation.findNavController(holder.itemView)
                .navigate(R.id.action_homeFragment_to_orderList, bundle)
        }
    }

    fun updateData(newList: List<Menu>){
        listMenu.clear()
        listMenu.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listMenu.size

    class MenuViewHolder(val row: View) : RecyclerView.ViewHolder(row){
        val imageViewMenu = row.findViewById<ImageView>(R.id.imageViewImageMenu)
        val textViewNameMenu = row.findViewById<TextView>(R.id.textViewNameMenu)
        val textViewPriceMenu: TextView = row.findViewById<TextView>(R.id.textViewPriceMenu)
        val ImageButtonMenu: ImageButton = row.findViewById<ImageButton>(R.id.imageButtonMenu)
    }

}
