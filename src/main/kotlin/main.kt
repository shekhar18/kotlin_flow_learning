package org.example

import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
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


        val flowOperators = FlowOperators()
        val flowOperatorsProducer = flowOperators.useOperators()
        val cancelableProducer = flowOperators.flowCancellation()

        flowOperatorsProducer.collect {
            delay(1000)
            println("$it")
        }
        cancelableProducer.cancellable()
            .catch { println("${it.message}") }
            .onCompletion { println("this is get completed") }.collect {
            if (it == 10) {
                println("now this flow will cancel")
                cancel()
            }
            println(it)
        }

    }
}