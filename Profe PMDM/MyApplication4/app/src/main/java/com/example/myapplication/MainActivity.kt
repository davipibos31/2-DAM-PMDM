package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapterCandies : CandieAdapterGrid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setListeners()
    }

    private fun initViews() {
        val items = ArrayList<Candie>()
        items.add(Candie("caramelos", R.drawable.ic_launcher_foreground))
        items.add(Candie("chupa-chups", R.mipmap.ic_launcher))
        items.add(Candie("corazones", R.drawable.ic_launcher_foreground))
        items.add(Candie("pirufrutas", R.mipmap.ic_launcher))
        items.add(Candie("rosquillas", R.drawable.ic_launcher_foreground))
        items.add(Candie("frutimelos", R.mipmap.ic_launcher))
        items.add(Candie("ositos", R.mipmap.ic_launcher))
        items.add(Candie("habichuelas", R.mipmap.ic_launcher))
        items.add(Candie("lacasitos", R.mipmap.ic_launcher))

        adapterCandies = CandieAdapterGrid(this, items)
        gridview.adapter = adapterCandies
    }

    private fun setListeners() {
        gridview.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, position, l ->
                val item = adapterCandies.getItem(position)
                Toast.makeText(this, "Has hecho click en ${item.name}", Toast.LENGTH_LONG)
                    .show()
                Log.d("MainActivity","Has hecho click en ${item.name}")
            }
    }
}