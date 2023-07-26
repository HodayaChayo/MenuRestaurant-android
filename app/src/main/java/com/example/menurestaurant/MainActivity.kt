package com.example.menurestaurant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import java.text.ParsePosition

class MainActivity : AppCompatActivity() {

    lateinit var myList: ListView

    var myArray =
        arrayOf(
            "Regular Burger",
            "Double Burger",
            "Kids Burger",
            "Home Fries",
            "French Fries",
            "Extra Burger",
            "Stake",
            "meat Sandwich"
        )

    var myimages = arrayOf(
        R.drawable.regularburger,
        R.drawable.doubleburger,
        R.drawable.kidsburger,
        R.drawable.homefries,
        R.drawable.frenchfries,
        R.drawable.extraburger,
        R.drawable.stake,
        R.drawable.meatsandwich
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myList = findViewById(R.id.myList)

        myList.adapter = ListViewClass()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        fun goAbout() {
            var intent = Intent(this, AboutScreen::class.java)
            startActivity(intent)
        }

        when (item.itemId) {

            R.id.about -> goAbout()
        }
        return super.onOptionsItemSelected(item)
    }

    inner class ListViewClass() :
        BaseAdapter() {

        override fun getCount(): Int {

            return myArray.size
        }

        override fun getItem(position: Int): Any {

            return myArray[position]
        }

        override fun getItemId(position: Int): Long {

            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var view = layoutInflater.inflate(R.layout.row, parent, false)

            var text: TextView
            text = view.findViewById(R.id.myText)
            text.text = myArray[position]

            var image: ImageView
            image = view.findViewById(R.id.myImage)
            image.setImageResource(myimages[position])

            return view
        }

    }
}
