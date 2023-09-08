package com.example.versionedtest

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TAG = "MainActivity"

        lifecycleScope.launch {

            viewModel.stateFlow.collectLatest {number ->

                val button = findViewById<Button>(R.id.button)
                val text = findViewById<TextView>(R.id.activityContent)

                button.setOnClickListener {
                    text.text = number.toString()
                }

            }

        }


    }
}