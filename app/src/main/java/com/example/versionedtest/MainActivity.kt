package com.example.versionedtest

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creating a coroutines with specific thread
        GlobalScope.launch(Dispatchers.Main) {

//            Log.d(TAG, "I am from thread:: ${Thread.currentThread().name}")

        }

        // Creating a coroutines with specific thread
        GlobalScope.launch(Dispatchers.IO) {

//            Log.d(TAG, "I am from thread:: ${Thread.currentThread().name}")

        }

        // Creating a coroutine with custom name
        GlobalScope.launch(newSingleThreadContext("myThread")) {

            Log.d(TAG, "I am from thread:: ${Thread.currentThread().name}")
            val response = doNetworkCall()

            // Changing from the working thread to the mentioned below using withContext
            withContext(Dispatchers.Main) {
                Log.d(TAG, "I am from thread:: ${Thread.currentThread().name}")
                val word = findViewById<TextView>(R.id.text)
                word.text = response
            }

        }

    }

    suspend fun doNetworkCall(): String {
        delay(3000)
        return "I am done with the network call ..."
    }


}