package com.example.brewalacoffe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class GetStarted : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_started, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonGetStarted).setOnClickListener {

            // set app tidak membuka get started lagi
            PreferenceManager.setOpened(requireContext())

            // lempar ke halaman utama
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentGetStarted, HomeFragment())
                .commit()
        }
    }
}