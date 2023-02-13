package com.example.cartedeprsentation

import android.content.Context
import android.content.Intent
import android.graphics.Color.BLUE
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
import androidx.activity.ComponentActivity
import com.example.firstapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val myButton: Button = findViewById(R.id.button4)

        part7(this)
    }
}

fun part5(activity: MainActivity) {
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

fun part6(activity: MainActivity) {
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

fun part7(activity: MainActivity) {
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

    //Make a popup appear diplaying the department name and its population
    listView.setOnItemClickListener { parent, view, position, id ->
        /*val cityNameMaybe = parent.getItemAtPosition(position)

        val popup = PopupMenu(activity, view)
        popup.menuInflater.inflate(R.menu.popup_listview, popup.menu)*/
        val inflater = LayoutInflater.from(parent.context)
        val popupView = inflater.inflate(R.layout.list_interface, null)

        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT
        val focusable = true

        val popupWindow = PopupWindow(popupView, width, height, focusable)

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)    }

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
