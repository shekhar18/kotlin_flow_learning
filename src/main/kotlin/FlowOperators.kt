package org.example

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class FlowOperators {

    //in this example, we see the multiple operator
    /*
    * 1.Intermediate Operators =>map, filter, take, onEach, transform, reduce, fold
    * 2.Terminal Operators => collect, toList, first, last, single, debounce
    * Intermediate Operators
        🔹 Transforming
            map – Transforms each value.
            mapLatest – Cancels previous transform if a new value comes in.
            flatMapConcat – Flattens flows sequentially.
            flatMapMerge – Flattens flows concurrently.
            flatMapLatest – Cancels previous flow and switches to the latest.
        🔹 Filtering
            filter – Emits only values that match the condition.
            filterNot – Emits values that do not match the condition.
            distinctUntilChanged – Emits only if value is different from the previous.
            take(n) – Emits only the first n values.
            drop(n) – Skips the first n values.
            debounce(time) – Emits the last value after a timeout of no new values.
            sample(time) – Emits the latest value at regular intervals.
        🔹 Combining
            combine – Combines latest values from multiple flows.
            zip – Pairs values from two flows by index.
            merge – Emits values from multiple flows concurrently.
        🔹 Control
            onEach – Perform an action (e.g., logging) on each emission.
            transform – Fully custom transformation and emission logic.
       Terminal Operators
            collect – Collects the emitted values (starts the flow).
            first – Returns the first emitted value.
            last – Returns the last emitted value.
            toList() – Collects all values into a list.
            count() – Returns the number of emissions.
            reduce() – Accumulates values to a single result.
            fold() – Like reduce, but with an initial value.
    * */


    fun useOperators(): Flow<Int> {
        return (1..10).asFlow()
            .onEach { println("before collecting we will operate it. : $it") }
            .filter { it % 2 == 0 }
            .map { it * it }

    }


}