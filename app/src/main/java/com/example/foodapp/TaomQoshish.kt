package com.example.foodapp

import Cache.AppCache
import Models.Food
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_taom_qoshish.*

class TaomQoshish : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taom_qoshish)

        back2.setOnClickListener {
            startActivity(Intent(this, MainActivity()::class.java))
        }

        AppCache.init(this)

        saqlash.setOnClickListener {
            val name = edt_food_name.text.toString().trim()
            val products = edt_required_products.text.toString().trim()
            val mode = edt_cooking_mode.text.toString().trim()

            if (name != "" && products != "" && mode != "") {
                val list = AppCache.objectString
                list.add(Food(name, products, mode))
                AppCache.objectString = list
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Fill in the fields!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}