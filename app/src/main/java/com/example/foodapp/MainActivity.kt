package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        card_menu.setOnClickListener {
            startActivity(Intent(this, BarchaTaomlar()::class.java))
        }

        card_taomlar.setOnClickListener {
            startActivity(Intent(this, TaomQoshish()::class.java))
        }

    }
}