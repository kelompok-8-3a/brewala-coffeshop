package com.example.brewalacoffe.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.brewalacoffe.home.MainActivity
import com.example.brewalacoffe.R

class RegistrasiFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(
            R.layout.fragment_registrasi,
            container,
            false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonToLogin = view.findViewById<TextView>(R.id.textViewRegister)
        val buttonRegister = view.findViewById<Button>(R.id.buttonRegister)

        buttonToLogin.setOnClickListener {
            (activity as LoginActivity).
            replaceLoginToRegister(
                LoginFragment()
            )
        }

        buttonRegister.setOnClickListener {
            val intentToHomeActivity = Intent(
                requireActivity(),
                MainActivity::class.java
            )
            startActivity(intentToHomeActivity)
            requireActivity().finish()
        }
    }



}