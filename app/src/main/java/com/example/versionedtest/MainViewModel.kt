package com.example.versionedtest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    // This is how we start a flow
    // This flow of type Int and should emit Int value
    private val countDownFlow = flow<Int> {

        val startingValue = 10
        var currentValue = startingValue
        emit(startingValue)
        while (currentValue > 0) {

            delay(1000)
            currentValue--
            // This emit function is the one used for sending the updated value over that flow
            emit(currentValue)

        }

    }

//    init {
//        collectFlow()
//    }

     fun collectFlow() {
        GlobalScope.launch {

            // This will collect the emmitions
            // also there is collectLatest and the difference is that it emits the latest emit and if there is a previous block should be cancelled
            countDownFlow.collect { time ->

                println("Current time is $time")

            }

        }
    }

}