package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class HotFlow {
    private val _hotFlow = MutableSharedFlow<Int>(replay = 1)
    val hotFlow = _hotFlow
    //here we're passing hotflow object to another place to collect value
    fun creatingHotFlow(): MutableSharedFlow<Int> {
        return hotFlow
    }

    suspend fun flowEmit(emitValue: Int) {
        _hotFlow.emit(emitValue)
    }

    suspend fun collectHotFlow(collectorName:String){
        hotFlow.collect {
            println("$collectorName collect value : $it")
        }
    }

}