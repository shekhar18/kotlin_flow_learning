package org.example

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
    }
}