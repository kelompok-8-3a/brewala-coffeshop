package com.example.brewalacoffe.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brewalacoffe.Menu
import com.example.brewalacoffe.Promo
import com.example.brewalacoffe.R

class PromoAdapter(
    val listPromo: List<Promo>):
    RecyclerView.Adapter<PromoAdapter.PromoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PromoAdapter.PromoViewHolder {
        val layout: View = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_promo,
                parent,
                false)

        return PromoViewHolder(layout)
    }

    override fun onBindViewHolder(
        holder: PromoViewHolder,
        position: Int) {

        val promo: Promo = listPromo.get(position)

        holder.TextViewCategoryPromo.text = promo.typePromo.toString()
        holder.textViewDescribePromo.text = promo.describePromo
        holder.imageViewPromo.setImageResource(promo.imagePromo)

    }

    override fun getItemCount(): Int = listPromo.size


    class PromoViewHolder(val row: View) : RecyclerView.ViewHolder(row){
        val TextViewCategoryPromo = row.findViewById<TextView>(R.id.TextViewCategoryDiscount)
        val imageViewPromo = row.findViewById<ImageView>(R.id.ImageViewDiscount)
        val textViewDescribePromo = row.findViewById<TextView>(R.id.TextVeiwDescribeDiscount)
    }

}