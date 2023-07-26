package es.javiercarrasco.myrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import es.javiercarrasco.myrecyclerview.databinding.ItemAnimalListBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var animals: MutableList<MyAnimals> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(animalsList: MutableList<MyAnimals>, contxt: Context) {
        this.animals = animalsList
        this.context = contxt
    }

    // Devuelve el ViewHolder ya creado.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemAnimalListBinding.inflate(
                layoutInflater,
                parent, false
            ).root
        )
    }

    // Pasa los objetos uno a uno al ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = animals.get(position)
        holder.bind(item)
    }

    // Devuelve el tamaño de la fuente de datos.
    override fun getItemCount(): Int {
        return animals.size
    }

    // rellena la vistas que se inflarán el RV.
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemAnimalListBinding.bind(view)

        fun bind(animal: MyAnimals) {
            binding.tvNameAnimal.text = animal.animalName
            binding.tvLatinName.text = animal.latinName
            binding.ivAnimalImage.setImageResource(animal.imageAnimal!!)

            itemView.setOnClickListener {
                Toast.makeText(
                    context,
                    animal.animalName,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}