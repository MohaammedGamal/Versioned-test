package com.example.versionedtest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val countDownFlow = flow<Int> {

        val startingValue = 5
        var currentValue = startingValue
        emit(startingValue)
        while (currentValue > 0) {

            delay(1000)
            currentValue--

            emit(currentValue)

        }

    }


     fun collectFlow() {
        GlobalScope.launch {

//            val result = countDownFlow
//                    // Flow operator that apply that boolean block inside it to the values passed by the emmisions then pass it to the collect
//                    // Here there is a lambda function that takes time as parameter
//                .filter { time ->
//                    time % 2 == 0
//                }
//                    // Do something with the flow values
//                .map { time ->
//                    time * time
//                }
//                    // Do something also with each item of the flow and this one returns a flow doesn't end it
//                .onEach { time ->
//                    println(time)
//                }
////                .collect { time ->
////
////                println("Current time is $time")
////
////            }
//                    // This type of flows called terminal flow as it's getting the final result of the flow and execute the code within it
//                .count {
//                    it % 2 == 0
//                }

//            println("Result is $result")

            val anotherTest = countDownFlow.reduce{ accumulator, value ->
                accumulator + value
            }

            println("Result is ${anotherTest}")

        }
    }

}