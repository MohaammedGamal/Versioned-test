package com.example.versionedtest

import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val job1 = GlobalScope.launch(Dispatchers.Default) {

            // This function gives the coroutine a time out that if it takes after it it will be cancelled
            withTimeout(2000) {
                repeat(5) {
                    // This isActive property checks if the coroutines is still active or it's cancelled or paused
                    if(isActive) {
                        Log.d(TAG, "Job 1 is still working ...")
                        delay(1000)
                    }
                }
            }

        }

        runBlocking {
//            job1.join()
            delay(2000)
            job1.cancel()
            Log.d(TAG, "I am done with runblocking block ...")
        }

    }


}