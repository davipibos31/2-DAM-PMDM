package es.javiercarrasco.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import es.javiercarrasco.myrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val myAdapter: RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.myRVAnimals.setHasFixedSize(true)

        binding.myRVAnimals.layoutManager = LinearLayoutManager(this)

        myAdapter.RecyclerAdapter(getAnimals(), this)

        binding.myRVAnimals.adapter = myAdapter
    }

    private fun getAnimals(): MutableList<MyAnimals> {
        val animals: MutableList<MyAnimals> = arrayListOf()

        animals.add(MyAnimals("Cisne", "Cygnus olor", R.mipmap.cisne))
        animals.add(MyAnimals("Erizo", "Erinaceinae", R.mipmap.cisne))
        animals.add(MyAnimals("Gato", "Felis catus", R.mipmap.cisne))
        animals.add(MyAnimals("Gorrión", "Passer domesticus", R.mipmap.cisne))
        animals.add(MyAnimals("Mapache", "Procyon", R.mipmap.cisne))
        animals.add(MyAnimals("Oveja", "Ovis aries", R.mipmap.cisne))
        animals.add(MyAnimals("Perro", "Canis lupus familiaris", R.mipmap.cisne))
        animals.add(MyAnimals("Tigre", "Panthera tigris", R.mipmap.cisne))
        animals.add(MyAnimals("Zorro", "Vulpes vulpes", R.mipmap.cisne))

        return animals
    }
}