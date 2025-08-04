package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class HotFlow {
    val hotFlow = MutableSharedFlow<Int>(replay = 1)
    fun creatingHotFlow(): MutableSharedFlow<Int> {
        return hotFlow
    }

    suspend fun flowEmit(emitValue: Int) {
        hotFlow.emit(emitValue)
    }


    suspend fun collectHotFlow(collectorName:String){

        hotFlow.collect {
            println("$collectorName collect value : $it")
        }
    }
}