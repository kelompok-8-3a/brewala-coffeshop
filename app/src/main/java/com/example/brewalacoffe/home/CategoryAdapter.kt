package com.example.brewalacoffe.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brewalacoffe.FilterCategoryMenu
import com.example.brewalacoffe.R

enum class CategoryMenu {
    ALL,
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
    val onFilter: (CategoryMenu) -> Unit
):
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

        private var selectedPosition = 0

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
        holder.textViewCategory.text = category.name.replace("_", " ")

        if (position == selectedPosition) {
            holder.row.setBackgroundResource(R.color.white)
            holder.textViewCategory.setTextColor(holder.itemView.context.getColor(R.color.text_main))
        } else {
            holder.row.setBackgroundResource(R.color.text_main)
            holder.textViewCategory.setTextColor(holder.itemView.context.getColor(R.color.white))
        }

        holder.row.setOnClickListener {
            if (selectedPosition != position) {
                val previousSelectedPosition = selectedPosition
                selectedPosition = position
                notifyItemChanged(previousSelectedPosition)
                notifyItemChanged(selectedPosition)
                onFilter(category)
            }
        }
    }

    override fun getItemCount(): Int = listCategory.size


    class CategoryViewHolder(val row: View) : RecyclerView.ViewHolder(row){
        val textViewCategory = row.findViewById<TextView>(R.id.textViewCategoryMenu)

    }
}