package com.example.brewalacoffe.login

import android.content.Context
import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.brewalacoffe.login.GetStarted
import com.example.brewalacoffe.PreferenceManager
import com.example.brewalacoffe.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if(PreferenceManager.isFirstOpen(this)){
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frameContainer,
                    GetStarted())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frameContainer,
                    LoginFragment())
                .commit()
        }
    }

    fun replaceLoginToRegister(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }
}