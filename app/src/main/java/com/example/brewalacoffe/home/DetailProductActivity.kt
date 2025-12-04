package com.example.brewalacoffe.home

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.brewalacoffe.R

class DetailProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_product)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textViewNameMenu = findViewById<TextView>(R.id.txtNamaProduk)
        val textViewPrice = findViewById<TextView>(R.id.txtHarga)
        val imageViewProduct = findViewById<ImageView>(R.id.imageProduct)
        val textViewDeskripsi = findViewById<TextView>(R.id.txtDeskripsi)

        val getInformationMenu = {
            name:String -> getIntent().getStringExtra(name)
        }

        textViewNameMenu.text = getInformationMenu(HomeFragment.NAME_PRODUCT)
        textViewPrice.text = getInformationMenu(HomeFragment.PRICE_PRODUCT)
        textViewDeskripsi.text = getInformationMenu(HomeFragment.DESCRIBE_PRODUCT)
        val imageProduct = getIntent().getIntExtra(HomeFragment.IMAGE_PRODUCT, 0)

        imageViewProduct.setImageResource(imageProduct)
    }
}