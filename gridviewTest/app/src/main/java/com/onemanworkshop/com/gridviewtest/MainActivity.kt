package com.onemanworkshop.com.gridviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    private val imgText =
        arrayOf("cat", "flower", "hippo", "monkey", "mushroom", "panda", "rabbit", "raccoon")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = ArrayList<Map<String, Any>>()
        for (i in imgText.indices) {
            val item = HashMap<String, Any>()
            item["image"] = R.drawable.ldr_chip_5k
            item["text"] = imgText[i]
            items.add(item)
        }

        val adapter = SimpleAdapter(
            this,
            items, R.layout.grid_item, arrayOf("image", "text"),
            intArrayOf(R.id.image, R.id.text)
        )
        main_page_gridview.adapter = adapter

        main_page_gridview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Clicked item :" + " " + position, Toast.LENGTH_SHORT).show()

        }
    }


}


