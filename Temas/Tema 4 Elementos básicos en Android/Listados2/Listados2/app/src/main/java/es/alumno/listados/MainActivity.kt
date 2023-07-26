package es.alumno.listados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setListeners()
    }

    private fun initViews() {
        val items = ArrayList<Chat>()
        items.add(Chat("Grupo PMDM", "Hola grupo", R.drawable.ic_launcher_foreground))
        items.add(Chat("Grupo PSP", "Que tal estais", R.mipmap.ic_launcher))
        items.add(Chat("Grupo PMDM", "Hola grupo", R.drawable.ic_launcher_foreground))
        items.add(Chat("Grupo PSP", "Que tal estais", R.mipmap.ic_launcher))
        items.add(Chat("Grupo PMDM", "Hola grupo", R.drawable.ic_launcher_foreground))
        items.add(Chat("Grupo PSP", "Que tal estais", R.mipmap.ic_launcher))

        adapter = ChatAdapter(this, items)
        listView.adapter = adapter

    }

    private fun setListeners() {
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, position, l ->
                Toast.makeText(this, "Has hecho click en ${adapter?.getItem(position)?.title}", Toast.LENGTH_LONG)
                    .show()
            }
    }
}