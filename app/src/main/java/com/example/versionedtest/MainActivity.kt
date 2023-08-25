package com.example.versionedtest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "I am the start of the app ...")

        // This run blocking is running on the main thread and it blocks the thread it's running
        runBlocking {
            launch(Dispatchers.IO) {
                delay(5000)
                Log.d(TAG, "Hi there i am before the delay function inside runBlocking ...")
            }
            delay(10000)
            Log.d(TAG, "I am from ${Thread.currentThread().name} and run after 5 seconds delay of the main thread")
            launch {
                Log.d(TAG, "Hi there i am after the delay function inside runBlocking")
            }
        }

//        Log.d(TAG, "I am from thread ${Thread.currentThread().name}")

    }


}