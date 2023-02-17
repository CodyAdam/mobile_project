package com.example.firstapp.ui.theme

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.example.firstapp.MainActivityXML
import com.example.firstapp.R

class RowAdapter(list: Array<String>, context: MainActivityXML) : BaseAdapter() {
    private var list = list
    private var context = context

    override fun getCount() : Int {
        return list.size
    }

    override fun getItem(pos: Int): Any? {
        return list[pos]
    }

    override fun getItemId(pos: Int) : Long {
        return 0
        //just return 0 if your list items do not have an Id variable.
    }

    override fun getView(position : Int, convertView : View, parent : ViewGroup) : View {
        var view = convertView
        if (view == null) {
            val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_view_row, null);
        }

        //Handle TextView and display string from your list
        val tv : TextView = view.findViewById(R.id.textView3);
        tv.text = list[position];

        //Handle buttons and add onClickListeners
        val btn : Button = view.findViewById(R.id.button8);

        btn.setOnClickListener {
            //delete file
            context.deleteFile(tv.text.toString())
        }

        return view;
    }
}