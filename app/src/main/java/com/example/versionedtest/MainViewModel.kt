package com.example.versionedtest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    // This is the mutable version of the flow
    private val _stateFlow = MutableStateFlow(0)
    // This is the immutable version of the flow which will hold the data
    val stateFlow = _stateFlow.asStateFlow()

    fun increaseCounter() {

        _stateFlow.value += 1

    }

}