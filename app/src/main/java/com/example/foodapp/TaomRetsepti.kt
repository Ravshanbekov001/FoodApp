package com.example.foodapp

import Cache.AppCache
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_taom_retsepti.*

class TaomRetsepti : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taom_retsepti)

        AppCache.init(this)
        val list = AppCache.objectString

        val position = intent.getIntExtra("position", 0)
        taom_nomi.text = list[position].name
        retsept.text = list[position].ingredients
        tayyorlanish_tartibi.text = list[position].preparationOrder
    }
}