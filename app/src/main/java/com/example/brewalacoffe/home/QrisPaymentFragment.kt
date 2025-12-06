package com.example.brewalacoffe.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.brewalacoffe.R

class QrisPaymentFragment : Fragment() {
    private var totalbayar: Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        totalbayar = arguments?.getInt("pay") ?: 30
        return inflater.inflate(R.layout.fragment_qris_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtPrice = view.findViewById<TextView>(R.id.txtTotalHarga)
        txtPrice.text = "Rp. " + totalbayar
        // tombol back
        val btnBack = view.findViewById<View>(R.id.btnBackQris)
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
