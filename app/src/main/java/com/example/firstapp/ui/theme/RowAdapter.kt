package com.example.firstapp.ui.theme

import android.annotation.SuppressLint
import android.content.Intent.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.firstapp.ActivityTp23XML
import com.example.firstapp.R

class RowAdapter(list: Array<String>, context: ActivityTp23XML) : BaseAdapter() {
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

    @SuppressLint("ViewHolder")
    override fun getView(position : Int, convertView : View?, parent : ViewGroup) : View {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_view_row, parent, false)

        //Handle TextView and display string from your list
        val tv : TextView = view.findViewById(R.id.textView3)
        tv.text = list[position];

        //Handle buttons and add onClickListeners
        val btn : Button = view.findViewById(R.id.button8)

        btn.setOnClickListener {
            //delete file
            context.deleteFile(tv.text.toString())
            Toast.makeText(context, "File deleted !", Toast.LENGTH_SHORT).show()
            val listView : ListView = context.findViewById(R.id.listview1)
            val files : Array<String> = context.fileList()
            val arrayAdapter = RowAdapter(files, context)
            listView.adapter = arrayAdapter
        }

        return view;
    }
}