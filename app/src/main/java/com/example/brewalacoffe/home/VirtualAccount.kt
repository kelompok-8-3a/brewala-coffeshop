package com.example.brewalacoffe.home

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.brewalacoffe.R

class VirtualAccount : Fragment() {
    private var pym: Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pym = arguments?.getInt("pay") ?: 9999
        val view = inflater.inflate(R.layout.virtual_account, container, false)

        // Sesuai ID dari XML kamu
        val btnBack = view.findViewById<ImageView>(R.id.btnBack)
        val txtVA = view.findViewById<TextView>(R.id.tvVA)
        val VAtotal = view.findViewById<TextView>(R.id.tvTotal)
        val btnCopy = view.findViewById<Button>(R.id.btnCopy)
        val btnDone = view.findViewById<Button>(R.id.btnSudahBayar)

        // tombol back
        btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        VAtotal.text ="Rp. " + pym.toString()
        // tombol copy VA
        btnCopy.setOnClickListener {
            val clipboard = requireContext()
                .getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

            val clip = ClipData.newPlainText("VA Number", txtVA.text.toString())
            clipboard.setPrimaryClip(clip)

            Toast.makeText(
                requireContext(),
                "Nomor VA berhasil disalin",
                Toast.LENGTH_SHORT
            ).show()
        }

        // tombol sudah bayar
        btnDone.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Terima kasih, pembayaran sedang diproses",
                Toast.LENGTH_SHORT
            ).show()

            androidx.navigation.Navigation.findNavController(requireView())
                .navigate(R.id.action_virtualAccountFragment_to_homeFragment2,)
        }

        return view
    }
}
