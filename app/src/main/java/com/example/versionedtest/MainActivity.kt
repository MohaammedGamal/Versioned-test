package com.example.versionedtest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This is where we can launch a coroutine
        // GlogalScope means that this coroutine will live as long the application does
        // If coroutine finishes it's job it will be destroyed automatically
        GlobalScope.launch {

            // Pause the coroutine but not blocking the while thread
//            delay(1000)

            Log.d(TAG, "I am the response of the network call and it is { ${doNetworkCall()} }")
            Log.d(TAG, "I am the response of the network call and it is { ${doNetworkCall2()} }")

            Log.d(TAG, "I am inside the GlobalScope and thread is ${Thread.currentThread().name}")

        }

        Log.d(
            TAG,
            "I am inside the onCreate function directly and Thread is ${Thread.currentThread().name}"
        )

    }

    suspend fun doNetworkCall(): String {

        delay(3000L)

        return "This is the response 1 ..."

    }

    suspend fun doNetworkCall2(): String {

        delay(3000L)

        return "This is the response 2 ..."

    }

}