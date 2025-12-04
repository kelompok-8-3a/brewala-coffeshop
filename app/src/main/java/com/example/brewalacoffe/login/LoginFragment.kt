package com.example.brewalacoffe.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.brewalacoffe.home.MainActivity
import com.example.brewalacoffe.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(
            R.layout.fragment_login,
            container,
            false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonToRegister = view.findViewById<TextView>(R.id.textViewRegister)
        val buttonLogin = view.findViewById<Button>(R.id.buttonLogin)
        val username = view.findViewById<EditText>(R.id.etUsername)
        val password = view.findViewById<EditText>(R.id.etPassword)

        buttonToRegister.setOnClickListener {
            (activity as LoginActivity)
                .replaceLoginToRegister(
                    RegistrasiFragment()
                )
        }

        buttonLogin.setOnClickListener {
            val intentToHomeActivity = Intent(
                requireActivity(),
                MainActivity::class.java
            )

            val usernameString = username.text.toString()
            val passwordString = password.text.toString()

//            if (usernameString.isEmpty() || passwordString.isEmpty()) {
//                Toast.
//                makeText(
//                    activity,
//                    "Isi username dan password",
//                    Toast.LENGTH_SHORT)
//                    .show()

            if (usernameString == "" && passwordString == "") {
                Toast.
                makeText(
                    activity,
                    "Login berhasil",
                    Toast.LENGTH_SHORT)
                    .show()
                startActivity(intentToHomeActivity)
                requireActivity().finish()

            } else {
                Toast.makeText(
                    activity,
                    "Username atau password salah",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


}