package com.example.brewalacoffe.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.brewalacoffe.R

class ReviewOrder : Fragment() {

    private var coffeeName: String? = null
    private var coffeeType: String? = null
    private var price: Int? = 0
    private var size: String? = null
    private var quantity: Int = 2
    private var rating: Double = 0.0
    private var imageRes: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_review_order, container, false)

        // Ambil data dari fragment sebelumnya (Bundle)
        coffeeName = arguments?.getString("name") ?: "Cappuccino"
        coffeeType = arguments?.getString("type") ?: "With Oat Milk"
        price = arguments?.getInt("price") ?: 30
        size = arguments?.getString("size") ?: "S"
        quantity = arguments?.getInt("qty") ?: 2
        rating = arguments?.getDouble("rating") ?: 4.5
        imageRes = arguments?.getInt("image") ?: R.drawable.coffelate

        setupUI(view)

        return view
    }

    private fun setupUI(view: View) {


        val btnBack = view.findViewById<ImageButton>(R.id.btnBack)

        val imgCoffee = view.findViewById<ImageView>(R.id.imgCoffee)
        val txtTitle = view.findViewById<TextView>(R.id.txtTitle)
        val txtSubtitle = view.findViewById<TextView>(R.id.txtSubtitle)
        val txtRating = view.findViewById<TextView>(R.id.txtRating)
        val txtPrice = view.findViewById<TextView>(R.id.txtPrice)
        val txtSizeValue = view.findViewById<TextView>(R.id.txtSizeValue)

        val btnMinus = view.findViewById<ImageButton>(R.id.btnMinus)
        val btnPlus = view.findViewById<ImageButton>(R.id.btnPlus)
        val txtCount = view.findViewById<TextView>(R.id.txtCount)

        val txtTotalPrice = view.findViewById<TextView>(R.id.txtTotalPrice)
        val txtShipping = view.findViewById<TextView>(R.id.txtShipping)

        val bottomTotal = view.findViewById<TextView>(R.id.bottomTotal)
        val buyButton = view.findViewById<LinearLayout>(R.id.bottomBar).getChildAt(1)

        // set data produk

        imgCoffee.setImageResource(imageRes)
        txtTitle.text = coffeeName
        txtSubtitle.text = coffeeType
        txtRating.text = rating.toString()
        txtPrice.text = "Rp. " + price
        txtSizeValue.text = size
        txtCount.text = quantity.toString()

// ongkir
        val shippingCost = 2000
        var total = (price ?: 0) * quantity
        var grandtotal = total + shippingCost

        txtTotalPrice.text = "Rp. " + total
        txtShipping.text = "Rp."+ shippingCost
        bottomTotal.text = "Total\nRp. " + grandtotal

// tombol +
        btnPlus.setOnClickListener {
            quantity++
            txtCount.text = quantity.toString()

            total = (price ?: 0) * quantity
            grandtotal = total + shippingCost
            txtTotalPrice.text = "Rp. " + total
            bottomTotal.text = "Total\nRp. " + grandtotal
        }

// tombol -
        btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                txtCount.text = quantity.toString()

                total = (price ?: 0) * quantity
                grandtotal = total + shippingCost
                txtTotalPrice.text = "Rp. " + total
                bottomTotal.text = "Total\nRp. " + grandtotal
            }
        }



        // button back

        btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }


        // button buy

        buyButton.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("grandtotal", grandtotal)
//                putInt("price", menu.priceMenu)
//                putInt("image", menu.imageMenu)
            }
            androidx.navigation.Navigation.findNavController(requireView())
                .navigate(R.id.action_orderList_to_payment, bundle)
        }

    }
}

