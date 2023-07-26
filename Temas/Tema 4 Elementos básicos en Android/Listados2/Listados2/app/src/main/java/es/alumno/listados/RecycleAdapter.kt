package es.alumno.listados

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.chat_item_adater.view.*

class RecycleAdapter(context: Context, items: ArrayList<Chat>) :
    RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {
    var context: Context? = null
    var items = ArrayList<Chat>()

    init {
        this.context = context
        this.items = items
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameView.text = item.title
        holder.descriptionView.text = item.description
        holder.imageView.setImageResource(item.image)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.chat_item_adater, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.name
        val descriptionView: TextView = view.description
        val imageView: ImageView = view.imageView
    }
}