package com.example.brewalacoffe.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brewalacoffe.R
import com.example.brewalacoffe.home.MenuAdapter.MenuViewHolder

enum class CategoryMenu {
    CAPUCCINO,
    LATTE,
    AMERICANO,
    EXPRESSO_BASED,
    COLD_CAFFE,
    FLAVORED
}

data class Category(
    val categoryMenu: CategoryMenu
)

class CategoryAdapter(
    val listCategory: List<CategoryMenu>,
    val onClickItemCategory: (CategoryMenu) -> Unit):
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val layout: View = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_category_menu,
                parent,
                false)

        return CategoryViewHolder(layout)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int
    ) {
        val category: CategoryMenu = listCategory.get(position)
        holder.textViewCategory.text = category.toString()

        holder.row.setOnClickListener {
            onClickItemCategory(category)
        }
    }

    override fun getItemCount(): Int = listCategory.size


    class CategoryViewHolder(val row: View) : RecyclerView.ViewHolder(row){
        val textViewCategory = row.findViewById<TextView>(R.id.textViewCategoryMenu)

    }
}