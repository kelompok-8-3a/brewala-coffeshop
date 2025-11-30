package com.example.brewalacoffe
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import kotlin.jvm.java
//
//class LoginActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//
//        val etUsername = findViewById<EditText>(R.id.etUsername)
//        val etPassword = findViewById<EditText>(R.id.etPassword)
//        val btnLogin = findViewById<Button>(R.id.btnLogin)
//        val tvRegister = findViewById<TextView>(R.id.tvRegister)
//        val tvForgot = findViewById<TextView>(R.id.tvForgotPassword)
//
//        btnLogin.setOnClickListener {
//            val username = etUsername.text.toString()
//            val password = etPassword.text.toString()
//
//            if (username.isEmpty() || password.isEmpty()) {
//                Toast.makeText(this, "Isi username dan password", Toast.LENGTH_SHORT).show()
//            } else if (username == "admin" && password == "12345") {
//                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
//                startActivity(Intent(this, MainActivity::class.java))
//                finish()
//            } else {
//                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        tvRegister.setOnClickListener {
//            startActivity(Intent(this, RegisterActivity::class.java))
//        }
//
//        tvForgot.setOnClickListener {
//            Toast.makeText(this, "Fitur belum tersedia", Toast.LENGTH_SHORT).show()
//        }
//    }
//}
