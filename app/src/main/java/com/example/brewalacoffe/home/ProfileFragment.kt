package com.example.brewalacoffe.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.brewalacoffe.R

class ProfileFragment : Fragment() {

    // Dipanggil ketika fragment ingin membuat tampilan (menghubungkan XML ke fragment)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    // Dipanggil setelah tampilan selesai dibuat → disini kita pasang tombol & event klik
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil ID dari XML
        val btnBack = view.findViewById<ImageView>(R.id.btnBack)
        val btnMyOrders = view.findViewById<View>(R.id.btnMyOrders)
        val btnPayment = view.findViewById<View>(R.id.btnPayment)
        val btnAddress = view.findViewById<View>(R.id.btnAddress)
        val btnSetting = view.findViewById<View>(R.id.btnSetting)
        val btnLogout = view.findViewById<TextView>(R.id.btnLogout)

        btnMyOrders.setOnClickListener {
            Toast.makeText(requireContext(), "My Orders diklik", Toast.LENGTH_SHORT).show()
            // findNavController().navigate(R.id.action_profile_to_orders) → setelah nav_graph siap
        }

        btnPayment.setOnClickListener {
            Toast.makeText(requireContext(), "Payment Methods diklik", Toast.LENGTH_SHORT).show()
        }

        btnAddress.setOnClickListener {
            Toast.makeText(requireContext(), "Address diklik", Toast.LENGTH_SHORT).show()
        }

        btnSetting.setOnClickListener {
            Toast.makeText(requireContext(), "Setting diklik", Toast.LENGTH_SHORT).show()
        }

        btnLogout.setOnClickListener {
            Toast.makeText(requireContext(), "Logout berhasil", Toast.LENGTH_SHORT).show()
        }
    }
}
