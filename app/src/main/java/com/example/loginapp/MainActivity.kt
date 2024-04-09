package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.loginapp.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var user : EditText
    lateinit var pW : EditText
    lateinit var loginbtn : Button
    lateinit var testbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = binding.user.text.toString()
        val pW = binding.pW.text.toString()

        binding.pW.transformationMethod = PasswordTransformationMethod.getInstance()

        binding.pW.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                validarCredenciales(user, pW)
                return@setOnEditorActionListener true
            }
            false
        }

        binding.loginbtn.setOnClickListener(View.OnClickListener {
            if (user.isEmpty() or pW.isEmpty()) {
               Toast.makeText(this, "Por favor, ingrese usuario y contraseña", Toast.LENGTH_SHORT).show()
            } else {
               validarCredenciales(user, pW)
            }
        })

        binding.testbtn.setOnClickListener(View.OnClickListener
        {
            val intent = Intent(this@MainActivity, WelcomePage::class.java)
            startActivity(intent)
        })


    }


    private fun validarCredenciales(user: String, pW: String) {
        if (binding.user.text.toString() == "admin" && binding.pW.text.toString() == "Pass") {
            Toast.makeText(this, "Autenticación Completada", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,WelcomePage::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Autenticación Fallida", Toast.LENGTH_LONG).show()
        }
    }
}



