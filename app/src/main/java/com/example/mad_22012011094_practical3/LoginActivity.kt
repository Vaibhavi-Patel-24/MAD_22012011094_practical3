package com.example.mad_22012011094_practical3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")
        val loginButton = findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener{
            val  intent = Intent(this,LoginActivity::class.java)
                .putExtra("username","vaibhavi")
                .putExtra("password","123")
                .also {
                    startActivity(intent)
                }

        }

    }
}