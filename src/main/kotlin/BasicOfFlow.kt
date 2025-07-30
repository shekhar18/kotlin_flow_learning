package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class BasicOfFlow {

    //in this section, we see how to create the basic of flow and collection

    /*
    * Basically, we have two types of Flows, 1.cold flows and 2. Hot flows
    * now we look first type which is cold flow.
    * */



    fun creatingBasicFlow(): Flow<Int> {
        return flow{
            repeat(10){
                delay(1000)
                emit(it)
            }
        }
    }

}