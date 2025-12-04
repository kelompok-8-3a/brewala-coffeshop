package com.example.brewalacoffe.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.brewalacoffe.PreferenceManager
import com.example.brewalacoffe.R

class GetStartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_get_started)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.getStarted)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.buttonGetStarted).setOnClickListener {
            PreferenceManager.setOpened(this)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }

}