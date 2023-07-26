package es.alumno.listados

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        initView()
    }

    private fun initView() {
        val items = ArrayList<Chat>()
        items.add(Chat("Grupo PMDM", "Hola grupo", R.drawable.ic_launcher_foreground))
        items.add(Chat("Grupo PSP", "Que tal estais", R.mipmap.ic_launcher))
        items.add(Chat("Grupo PMDM", "Hola grupo", R.drawable.ic_launcher_foreground))
        items.add(Chat("Grupo PSP", "Que tal estais", R.mipmap.ic_launcher))
        items.add(Chat("Grupo PMDM", "Hola grupo", R.drawable.ic_launcher_foreground))
        items.add(Chat("Grupo PSP", "Que tal estais", R.mipmap.ic_launcher))
        val adapter = RecycleAdapter(this, items)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}