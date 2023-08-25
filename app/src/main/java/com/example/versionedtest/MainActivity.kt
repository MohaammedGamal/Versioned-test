package com.example.versionedtest

import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {

            // This function is used to measure the time for it's block of code
            val time = measureTimeMillis {
                // This async function will execute the coroutine independent from the others so all will work at the same time, returns Deferred
                val answer1 = async { networkCall1() }
                val answer2 = async { networkCall2() }
                // This await() function is becuase of the deferred as it's telling the job to wait until the result is available then execute it
                Log.d(TAG, "Answer 1 is ${answer1.await()}")
                Log.d(TAG, "Answer 2 is ${answer2.await()}")
            }

            Log.d(TAG, "Time taken is $time")

        }

    }

    suspend fun networkCall1(): String {
        delay(3000)
        return "Answer 1"
    }

    suspend fun networkCall2(): String {
        delay(3000)
        return "Answer 2"
    }


}