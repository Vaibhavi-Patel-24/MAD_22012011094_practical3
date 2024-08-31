package com.example.mad_22012011094_practical3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginButton = findViewById<Button>(R.id.login_button_1)
        loginButton.setOnClickListener {
            Intent(this, LoginActivity::class.java)
                .putExtra("username", "vaibhavi")
                .putExtra("password", "123")
                .also {
                    startActivity(it)
                }
        }
            fun implicitIntent(){
            findViewById<Button>(R.id.browse_button).setOnClickListener {
                Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com")).also { startActivity(it) }
            }

            findViewById<Button>(R.id.call_button).setOnClickListener{
                val num = findViewById<EditText>(R.id.enter_phone_no).text.toString()
                Intent(Intent.ACTION_DIAL).setData(Uri.parse(num)).also {
                    startActivity(it)
                }
            }

                findViewById<Button>(R.id.call_log_button).setOnClickListener {
                    Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also {
                        startActivity(it)
                    }
                }
            findViewById<Button>(R.id.gallery_button).setOnClickListener {
                Intent(Intent.ACTION_VIEW).setType("image/*").also{
                    startActivity(it)
                }
            }

                findViewById<Button>(R.id.camera_button).setOnClickListener {
                    Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{
                        startActivity(it)
                    }
                }
                 findViewById<Button>(R.id.alarm_button).setOnClickListener {
                     Intent(AlarmClock.ACTION_SHOW_ALARMS).also{
                         startActivity(it)
                 }
                 }


            }
    }
}