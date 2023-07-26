package com.example.ejercicio491_492;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.empty_item_adapter.view.*

class StringlistAdapter: BaseAdapter {
 var context:Context?=null
    var items:ArrayList<Chat>

    constructor(context:Context, items: ArrayList<Chat>){
        this.context=context
        this.items=items
}
    override fun getCount(): Int {
     return this.items.size
    }

    override fun getItem(position: Int): Chat {
        return this.items[position]
    }

    override fun getItemId(position: Int): Long {
    return position.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {


        val item=this.items[position]

        val inflater=LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.empty_item_adapter,p2,false)

        view.txtadapterview.text=item.name
        return view
    }

}