package com.example.brewalacoffe.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.brewalacoffe.R

class DetailProdukFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // hubungkan fragment ke fragment_detail_produk.xml
        val view = inflater.inflate(R.layout.fragment_detail_produk, container, false)


        // AMBIL KOMPONEN DARI XML

        val imageProduct = view.findViewById<ImageView>(R.id.imageProduct)
        val txtNamaProduk = view.findViewById<TextView>(R.id.txtNamaProduk)
        val txtSubjudul = view.findViewById<TextView>(R.id.txtSubjudul)
        val txtHarga = view.findViewById<TextView>(R.id.txtHarga)

        val btnSizeS = view.findViewById<Button>(R.id.btnSizeS)
        val btnSizeM = view.findViewById<Button>(R.id.btnSizeM)
        val btnSizeL = view.findViewById<Button>(R.id.btnSizeL)

        val txtDeskripsi = view.findViewById<TextView>(R.id.txtDeskripsi)

        val btnBuyNow = view.findViewById<Button>(R.id.btnBuyNow)
        val btnAddToCart = view.findViewById<Button>(R.id.btnAddToCart)

        // ==============================
        // SET DATA PRODUK (bisa diganti dynamic dari database / bundle)
        // ==============================
        imageProduct.setImageResource(R.drawable.coffelate)
        txtNamaProduk.text = "Cappuccino"
        txtSubjudul.text = "With Oat Milk"
        txtHarga.text = "Rp 20.000"

        txtDeskripsi.text =
            "Sajian kopi klasik yang menggabungkan espresso berkualitas tinggi dengan susu panas bertekstur lembut..."

        // EVENT UNTUK PEMILIHAN SIZE

        btnSizeS.setOnClickListener {
            btnSizeS.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
            btnSizeM.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
            btnSizeL.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
        }

        btnSizeM.setOnClickListener {
            btnSizeM.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
            btnSizeS.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
            btnSizeL.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
        }

        btnSizeL.setOnClickListener {
            btnSizeL.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
            btnSizeS.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
            btnSizeM.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
        }


        // EVENT BUTTON

        btnBuyNow.setOnClickListener {
            // pindah ke halaman Review Order
            findNavController().navigate(R.id.action_detailProduk_to_reviewOrder)
        }

        btnAddToCart.setOnClickListener {
            // logika tambah cart
        }

        return view
    }
}
