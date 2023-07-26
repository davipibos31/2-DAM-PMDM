package com.example.ejercicio491_492;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: candi_adapter_grid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setListeners()
    }
private fun initViews() {

    val nombres = ArrayList<Chat>();
    nombres.add(Chat("chuche",R.drawable.ic_launcher_foreground))
    nombres.add(Chat("chupa-chups",R.drawable.ic_launcher_foreground))
    nombres.add(Chat("corazones",R.drawable.ic_launcher_foreground))
    nombres.add(Chat("pirufrutas",R.drawable.ic_launcher_foreground))
    nombres.add(Chat("rosquillas",R.drawable.ic_launcher_foreground))
    nombres.add(Chat("frutimelos",R.drawable.ic_launcher_foreground))
    nombres.add(Chat("ositos",R.drawable.ic_launcher_foreground))
    nombres.add(Chat("habichuelas",R.drawable.ic_launcher_foreground))
    nombres.add(Chat("lacasitos",R.drawable.ic_launcher_foreground))


     adapter = candi_adapter_grid(this, nombres)
    gridview.adapter = adapter


}

    private fun setListeners() {
        gridview.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, position, l ->
                val item=adapter.getItem(position)
                Toast.makeText(this, "Has hecho click en ${item.name}", Toast.LENGTH_LONG)
                    .show()
                Log.d("main activity","Has hecho click en ${item.name}" )
            }
    }


}

