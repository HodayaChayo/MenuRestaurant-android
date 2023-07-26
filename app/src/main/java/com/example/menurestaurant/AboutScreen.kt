package com.example.menurestaurant

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class AboutScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_screen)

        


    }

    fun sendToEmail(view: View?) {
        val sendemail = Intent(Intent.ACTION_SEND)
        sendemail.data = Uri.parse("mailto:")
        sendemail.type = "message/rfc822"
        sendemail.putExtra(
            Intent.EXTRA_EMAIL, arrayOf(
                "ezrachayu94@gmail.com"
            )
        )
        sendemail.putExtra(Intent.EXTRA_SUBJECT, "my app")
        sendemail.putExtra(Intent.EXTRA_TEXT, "Thank yuo for downloading my app")
        startActivity(sendemail)
    }

    fun shareApp(view: View?) {
        val textShare = "The memory game"
        val link = "https://www.google.com/"
        val share = Intent(Intent.ACTION_SEND)
        share.type = "text/plain"
        share.putExtra(
            Intent.EXTRA_TEXT, """
     $textShare
     $link
     """.trimIndent()
        )
        startActivity(Intent.createChooser(share, "My share"))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        fun goMenu() {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        when (item.itemId) {


            R.id.menu -> goMenu()
        }
        return super.onOptionsItemSelected(item)
    }
}