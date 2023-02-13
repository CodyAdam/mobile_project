package com.example.firstapp

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
import androidx.activity.ComponentActivity

class MainActivityXML : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val myButton: Button = findViewById(R.id.button4)

        //part1(this)
        //part2(this)
        //part3(this)
        //part4(this)
        //part5(this)
        //part6(this)
        part7(this)
    }
}

fun part1(activity: MainActivityXML) {
    activity.setContentView(R.layout.button_side)
}

fun part2(activity: MainActivityXML) {
    activity.setContentView(R.layout.button_bottom)
}

fun part3(activity: MainActivityXML) {
    activity.setContentView(R.layout.simple_interface)
}

fun part4(activity: MainActivityXML) {
    activity.setContentView(R.layout.simple_interface_relative)
}

fun part5(activity: MainActivityXML) {
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

fun part6(activity: MainActivityXML) {
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

fun part7(activity: MainActivityXML) {
    activity.setContentView(R.layout.list_interface)

    val listView : ListView = activity.findViewById(R.id.List)

    val arrayList = ArrayList<String>()
    arrayList.add("Ille-et-Vilaine")
    arrayList.add("Côtes d'Armor")
    arrayList.add("Finistère")
    arrayList.add("Morbihan")

    val arrayListPop = ArrayList<String>()
    arrayListPop.add("1 060 199")
    arrayListPop.add("598 814")
    arrayListPop.add("909 028")
    arrayListPop.add("750 863")

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
