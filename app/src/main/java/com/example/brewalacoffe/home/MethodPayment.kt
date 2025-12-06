package com.example.brewalacoffe.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.brewalacoffe.R
import androidx.constraintlayout.widget.ConstraintLayout


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MethodPayment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MethodPayment : Fragment() {
    private var tot: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_method_payment, container, false)

        tot = arguments?.getInt("grandtotal") ?: 9999

        // tombol back
        val btnBack = view.findViewById<ImageView>(R.id.back_arrow)

        // tombol method yang aktif
        val btnBri = view.findViewById<ConstraintLayout>(R.id.btn_bri_va)
        val btnQris = view.findViewById<ConstraintLayout>(R.id.btn_qris)

//         back
        btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        // klik BRI VA
        btnBri.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("pay", tot)
            }
            androidx.navigation.Navigation.findNavController(requireView())
                .navigate(R.id.action_payment_to_virtualAccountFragment, bundle)
        }

        // klik QRIS
        btnQris.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("pay", tot)
            }
            androidx.navigation.Navigation.findNavController(requireView())
                .navigate(R.id.action_payment_to_qrishPayment, bundle)
        }

        return view
    }
}
