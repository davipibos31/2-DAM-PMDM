package es.alumno.listados

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.spinner_activity.*

class SpinnerActivity : AppCompatActivity() {
    private val nombres = mutableListOf(
        "Javier", "Nacho", "Patricia", "Miguel", "Susana", "Rosa", "Juan",
        "Pedro", "Asunción", "Antonio", "Lorena", "Verónica", "Paola",
        "Esteban", "Andrea", "María"
    )
    private lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spinner_activity)
        initView()
        setListener()
    }

    private fun initView(){
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombres)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    private fun setListener(){
        spinner.onItemSelectedListener=
            object:AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    Toast.makeText(applicationContext,adapter.getItem(position),Toast.LENGTH_LONG).show()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    Toast.makeText(applicationContext,"Item no seleccionado.",Toast.LENGTH_LONG).show()

                }

            }
    }
}