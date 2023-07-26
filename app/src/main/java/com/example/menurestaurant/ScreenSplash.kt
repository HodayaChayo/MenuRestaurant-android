package com.example.menurestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ScreenSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_splash)

        val thread = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)
                } catch (e: java.lang.Exception) {
                } finally {
                    var intent = Intent(this@ScreenSplash, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }
        }
        thread.start()


    }
}