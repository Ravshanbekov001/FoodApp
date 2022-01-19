package com.example.foodapp

import Cache.AppCache
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_barcha_taomlar.*
import kotlinx.android.synthetic.main.item.view.*

class BarchaTaomlar : AppCompatActivity() {

    lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barcha_taomlar)

        back.setOnClickListener {
            startActivity(Intent(this, MainActivity()::class.java))
        }


        AppCache.init(this)
        val list = AppCache.objectString


        listAdapter = Adapters.ListAdapter(this, list)
        list_view.adapter = listAdapter

        list_view.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, TaomRetsepti::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }
}