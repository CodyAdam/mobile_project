package com.example.firstapp

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
import androidx.activity.ComponentActivity
import com.example.firstapp.ui.theme.RowAdapter

class MainActivityXML : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //tp2Part1(this)
        //tp2Part2(this)
        //tp2Part3(this)
        //tp2Part4(this)
        //tp2Part5(this)
        //tp2Part6(this)
        //tp2Part7(this)
        //tp3Part1(this)
        //tp3Part2(this)
        //tp3Part3(this)
        //tp3Part4(this)
        //tp3Part5(this)
        //tp3Part6(this)
        //tp3Part7(this)
    }
}

fun tp2Part1(activity: MainActivityXML) {
    activity.setContentView(R.layout.button_side)
}

fun tp2Part2(activity: MainActivityXML) {
    activity.setContentView(R.layout.button_bottom)
}

fun tp2Part3(activity: MainActivityXML) {
    activity.setContentView(R.layout.simple_interface)
}

fun tp2Part4(activity: MainActivityXML) {
    activity.setContentView(R.layout.simple_interface_relative)
}

fun tp2Part5(activity: MainActivityXML) {
    activity.setContentView(R.layout.list_interface)

    val listView : ListView = activity.findViewById(R.id.List)

    val arrayList = ArrayList<String>()
    arrayList.add("Ille-et-Vilaine")
    arrayList.add("Côtes d'Armor")
    arrayList.add("Finistère")
    arrayList.add("Morbihan")

    val arrayAdapter : ArrayAdapter<String> = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, arrayList)

    listView.adapter = arrayAdapter

}

fun tp2Part6(activity: MainActivityXML) {
    activity.setContentView(R.layout.list_interface)

    val listView : ListView = activity.findViewById(R.id.List)

    val arrayList = ArrayList<String>()
    arrayList.add("Ille-et-Vilaine")
    arrayList.add("Côtes d'Armor")
    arrayList.add("Finistère")
    arrayList.add("Morbihan")

    for (i in 0 until arrayList.size) {
        arrayList[i] = (arrayList[i] + " - Bretagne")
    }

    val arrayAdapter : ArrayAdapter<String> = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, arrayList)

    listView.adapter = arrayAdapter

}

fun tp2Part7(activity: MainActivityXML) {
    activity.setContentView(R.layout.list_interface)

    val listView : ListView = activity.findViewById(R.id.List)

    val arrayList = ArrayList<String>()
    arrayList.add("Ille-et-Vilaine")
    arrayList.add("Côtes d'Armor")
    arrayList.add("Finistère")
    arrayList.add("Morbihan")

    val arrayListPop = ArrayList<String>()
    arrayListPop.add(" 1 060 199")
    arrayListPop.add(" 598 814")
    arrayListPop.add(" 909 028")
    arrayListPop.add(" 750 863")

    for (i in 0 until arrayList.size) {
        arrayList[i] = (arrayList[i] + " - Bretagne")
    }

    val arrayAdapter : ArrayAdapter<String> = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, arrayList)

    listView.adapter = arrayAdapter

    //Make a popup appear diplaying the department name and its population
    listView.setOnItemClickListener { parent, view, position, id ->
        //val cityNameMaybe = parent.getItemAtPosition(position.toInt())

        val inflater = LayoutInflater.from(parent.context)
        val popupView = inflater.inflate(R.layout.popup_listview, null)

        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT
        val focusable = true

        val popupWindow = PopupWindow(popupView, width, height, focusable)

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)

        val tv1: TextView = popupView.findViewById(R.id.textView1)
        tv1.text = arrayList[id.toInt()]
        val tv2: TextView = popupView.findViewById(R.id.textView2)
        tv2.text = arrayListPop[id.toInt()]

    }



}

//Visualize at /data/data/com.example.firstapp/files/ADAMCodyALLAINArthur in Device File Explorer
fun tp3Part1(activity: MainActivityXML) {
    val fileName = "ADAMCodyALLAINArthur"
    activity.baseContext.openFileOutput(fileName, Context.MODE_PRIVATE)
}

//Visualize at /data/data/com.example.firstapp/files/ADAMCodyALLAINArthur in Device File Explorer
fun tp3Part2(activity: MainActivityXML) {
    val fileName = "ADAMCodyALLAINArthur"
    val fileContent = "Bonjour MOUNIER Romain !"
    activity.baseContext.openFileOutput(fileName, Context.MODE_PRIVATE).use {
        it.write(fileContent.toByteArray())
    }
}

fun tp3Part3(activity: MainActivityXML) {
    activity.setContentView(R.layout.display_filename)
    val fileName = "ADAMCodyALLAINArthur"
    val fileContent = "Bonjour MOUNIER Romain !"
    activity.baseContext.openFileOutput(fileName, Context.MODE_PRIVATE).use {
        it.write(fileContent.toByteArray())
    }
    activity.baseContext.openFileInput("ADAMCodyALLAINArthur").bufferedReader().use {
        val tv: TextView = activity.findViewById(R.id.textView)
        tv.text = it.readText()
    }

}

fun tp3Part4(activity: MainActivityXML) {
    activity.setContentView(R.layout.write_okcancel)
    val fileName = "ADAMCodyALLAINArthur"
    val fileContent = "Bonjour MOUNIER Romain !"
    activity.baseContext.openFileOutput(fileName, Context.MODE_PRIVATE).use {
        it.write(fileContent.toByteArray())
    }
    activity.baseContext.openFileInput("ADAMCodyALLAINArthur").bufferedReader().use {
        val tv: TextView = activity.findViewById(R.id.editText)
        tv.text = it.readText()
    }
    val button5: Button = activity.findViewById(R.id.button5)
    button5.setOnClickListener {
        activity.baseContext.openFileOutput(fileName, Context.MODE_PRIVATE).use {
            val tv: TextView = activity.findViewById(R.id.editText)
            it.write((tv.text).toString().toByteArray())
        }
    }
    val button6: Button = activity.findViewById(R.id.button6)
    button6.setOnClickListener {
        activity.baseContext.openFileInput("ADAMCodyALLAINArthur").bufferedReader().use {
            val tv: TextView = activity.findViewById(R.id.editText)
            tv.text = it.readText()
        }
    }
}

fun tp3Part5(activity: MainActivityXML) {
    activity.setContentView(R.layout.create_file)
    val button7: Button = activity.findViewById(R.id.button7)
    button7.setOnClickListener {
        val tv: TextView = activity.findViewById(R.id.editText2)
        if(tv.text.toString().isBlank()) {
            Toast.makeText(activity, "Fill the blank !", Toast.LENGTH_SHORT).show()
        } else {
            activity.baseContext.openFileOutput(tv.text.toString(), Context.MODE_PRIVATE)
            Toast.makeText(activity, "File created !", Toast.LENGTH_SHORT).show()
        }
    }
}

fun tp3Part6(activity: MainActivityXML) {
    activity.setContentView(R.layout.create_file_show_files)

    val listView : ListView = activity.findViewById(R.id.listview1)
    val button7: Button = activity.findViewById(R.id.button7)

    val files : Array<String> = activity.fileList()
    val arrayAdapter : ArrayAdapter<String> = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, files)
    listView.adapter = arrayAdapter

    button7.setOnClickListener {
        val tv: TextView = activity.findViewById(R.id.editText2)
        if(tv.text.toString().isBlank()) {
            Toast.makeText(activity, "Fill the blank !", Toast.LENGTH_SHORT).show()
        } else {
            activity.baseContext.openFileOutput(tv.text.toString(), Context.MODE_PRIVATE)
            Toast.makeText(activity, "File created !", Toast.LENGTH_SHORT).show()
            val files : Array<String> = activity.fileList()
            val arrayAdapter : ArrayAdapter<String> = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, files)
            listView.adapter = arrayAdapter
        }
    }
}

fun tp3Part7(activity: MainActivityXML) {
    activity.setContentView(R.layout.create_file_delete_files)

    val listView : ListView = activity.findViewById(R.id.listview1)
    val button7: Button = activity.findViewById(R.id.button7)

    val files : Array<String> = activity.fileList()
    val arrayAdapter = RowAdapter(files, activity)
    listView.adapter = arrayAdapter

    button7.setOnClickListener {
        val tv: TextView = activity.findViewById(R.id.editText2)
        if(tv.text.toString().isBlank()) {
            Toast.makeText(activity, "Fill the blank !", Toast.LENGTH_SHORT).show()
        } else {
            activity.baseContext.openFileOutput(tv.text.toString(), Context.MODE_PRIVATE)
            Toast.makeText(activity, "File created !", Toast.LENGTH_SHORT).show()
            val files : Array<String> = activity.fileList()
            val arrayAdapter = RowAdapter(files, activity)
            listView.adapter = arrayAdapter
        }
    }
}

/*
@Composable
fun Greeting(name: String) {
    Surface(color = Color(BLUE)) {
        Text(text = "Hi, my name is $name!", modifier = Modifier.padding(24.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Box {
        Greeting("Cody") {
        }
    }
}*/
