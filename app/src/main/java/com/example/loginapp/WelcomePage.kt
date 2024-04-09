package com.example.loginapp

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.loginapp.databinding.ActivityMainBinding
import com.example.loginapp.databinding.WelcomePageBinding
import com.example.loginapp.ui.theme.LoginAppTheme
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab

private lateinit var binding: WelcomePageBinding

class WelcomePage : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = WelcomePageBinding.inflate(layoutInflater)
       setContentView(binding.root)

    }
}
