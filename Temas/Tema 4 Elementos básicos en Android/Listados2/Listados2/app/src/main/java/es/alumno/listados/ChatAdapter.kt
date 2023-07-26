package es.alumno.listados

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.chat_item_adater.view.*
import kotlinx.android.synthetic.main.empty_item_adapter.view.*

class ChatAdapter : BaseAdapter {
    var context: Context? = null
    var items = ArrayList<Chat>()

    constructor(context: Context, items: ArrayList<Chat>) {
        this.context = context
        this.items = items
    }

    override fun getCount(): Int {
        return this.items.size
    }

    override fun getItem(position: Int): Chat {
        return this.items[position]
    }

    override fun getItemId(p0: Int): Long {
        return 10
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val item = this.items[position]

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.chat_item_adater, p2, false)

        view.name.text = item.title
        view.imageView.setImageResource(item.image)
        view.description.text = item.description

        return view
    }
}