package com.example.brewalacoffe.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return inflater.inflate(
            R.layout.fragment_detail_produk,
            container,
            false
        )
    }

}
