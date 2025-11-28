package com.example.brewalacoffe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGetStarted = findViewById<Button>(R.id.btnGetStarted)

        btnGetStarted.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        if(PreferenceManager.isFirstOpen(this)){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentGetStarted, GetStarted())
                .commit()
        }

        else{
            // langsung tampilkan halaman utama
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentGetStarted, HomeFragment())
                .commit()
        }
    }
}
