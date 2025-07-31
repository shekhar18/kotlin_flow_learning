package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    //here we're creating the producer object from and collecting emitted values.
    //we use the run blocking to collect emitted values.
    runBlocking {
        val basicOfFlow = BasicOfFlow()
        val producer = basicOfFlow.creatingBasicFlow()

        //here we're collecting emitted values using collect function
        producer.collect {
            println("Collect value : ${it}")
        }

        //here we use the flow builder to create flow
        val flowBuilders = FlowBuilders()
        val fruitProducer = flowBuilders.convertListToTheFlow()
        val nameProvider = flowBuilders.getFlowHere()
        val cannelProducer = flowBuilders.channelFlow()

        fruitProducer.collect {
            delay(1000)
            println(it)
        }
        nameProvider.collect {
            delay(1000)
            println(it)
        }

        cannelProducer.collect {
            delay(2000)
            println(it)
        }

    }
}