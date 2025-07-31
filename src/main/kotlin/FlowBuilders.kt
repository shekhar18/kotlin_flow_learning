package org.example

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf

class FlowBuilders {

    // in this class we see the flow builder which is used to create the flow in kotlin
    // there are two flow builders we use for it
    //1.asFlow()
    //2.flowOf()


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

}