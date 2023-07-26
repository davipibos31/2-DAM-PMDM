package es.alumno.listados

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.empty_item_adapter.view.*

class EmptyAdapter : BaseAdapter {
    var context: Context? = null
    var items: List<String> = ArrayList<String>()

    constructor(context: Context, nombres: List<String>) {
        this.context = context
        this.items = nombres
    }

    override fun getCount(): Int {
        return this.items.size
    }

    override fun getItem(p0: Int): Any {
        return 5
    }

    override fun getItemId(p0: Int): Long {
        return 5
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val texto = this.items[position]

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.empty_item_adapter, p2, false)

        view.txtTitle.text = texto
        return view
    }
}