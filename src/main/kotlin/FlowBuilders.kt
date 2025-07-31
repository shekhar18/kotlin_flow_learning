package org.example

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class FlowBuilders {

    // in this class we see the flow builder which is used to create the flow in kotlin.
    // there are two flow builders we use for it
    //1.asFlow()=>Transforms collections or sequences into a flow.
    //2.flowOf()=>Useful for emitting predefined values.
    //3.flow{}=>Cold asynchronous stream and Emits values sequentially in a coroutine. (we see this in basic of flow)
    //4.channelFlow{}=>Cold stream with more concurrency control and Allows sending from multiple coroutines using send().
    //5.callbackFlow{}=>Bridge callback-based APIs to Flow to Convert callback/event listeners into Flow.
    // example: - ✅ Use callbackFlow to handle Android listeners, LiveData, or any event-driven APIs.

    fun convertListToTheFlow(): Flow<String> {

        //here we create the list of string
        val list = listOf<String>("apple","banana","greps","coconut","strawberry","lechi","guava","pineapple")
            // and here we're converting the list to flow and return it.
        return list.asFlow()

    }

    fun getFlowHere():Flow<String>{
        //here we
        return flowOf("Ramesh","suresh","priyanka","shekhar","pari","shivpriya","chinu","aadvet")
    }

    fun channelFlow(): Flow<String> = channelFlow {
        launch {
            send("From coroutine 1")
        }
        launch {
            send("From coroutine 2")
        }
    }

    /*fun locationUpdates(): Flow<Location> = callbackFlow {
        val callback = LocationCallback { location ->
            trySend(location)
        }

        startLocationUpdates(callback)

        awaitClose { stopLocationUpdates(callback) }
    }*/

}