package com.saket.kotlincollections

/*
Along with collections, the Kotlin standard library contains another container type – sequences (Sequence<T> ).
Sequences offer the same functions as Iterable but implement another approach to multi-step collection processing.
 */
class Sequences {

    /*
    When the processing of an Iterable includes multiple steps, they are executed eagerly:
    each processing step completes and returns its result – an intermediate collection.
    The following step executes on this collection.
    In turn, multi-step processing of sequences is executed lazily when possible:
    actual computing happens only when the result of the whole processing chain is requested.

    The order of operations execution is different as well:
    Sequence performs all the processing steps one-by-one for every single element.
    In turn, Iterable completes each step for the whole collection and then proceeds to the next step.

    So, the sequences let you avoid building results of intermediate steps,
    therefore improving the performance of the whole collection processing chain.
    However, the lazy nature of sequences adds some overhead which may be significant when processing
    smaller collections or doing simpler computations.
    Hence, you should consider both Sequence and Iterable and decide which one is better for your case.
     */

    /*
    Creating sequence:
    from chunks
     */

    //from elements
    val numberSequences = sequenceOf(1, 3, 4, 5, 6)

    //from iterables
    val myIterables = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    val daysSequences = myIterables.asSequence()

    //from function
    /*
    To build a sequence based on a function, call generateSequence() with this function as an argument.
    Optionally, you can specify the first element as an explicit value or a result of a function call.
    The sequence generation stops when the provided function returns null.
     */
    val infinteNumbersSequences = generateSequence(1) { it + 2}

    val finiteNumbersSequences = generateSequence(1) { if (it < 9) it +2 else null }


    fun testSequences() {
        /*
        Here we compare how iterable and sequences handle multi-step collection processing differently.
         */
        val words = "The quick brown fox jumps over the lazy dog".split(" ")
        /*

        val lengthsList = words.filter { println("filter: $it"); it.length > 3 }
            .map { println("length: ${it.length}"); it.length }
            .take(4)
        println("Lengths of first 4 words longer than 3 chars:")
        println(lengthsList)
*/

        /*
        Now same with sequence.
         */
        val wordsSequences = words.asSequence()

        val lengthsSequences = wordsSequences.filter { println("Sequence filter: $it"); it.length > 3 }
            .map { println("Sequence map: ${it.length}"); it.length }
            .take(4)

        // terminal operation: obtaining the result as a List
        println(lengthsSequences.toList())
    }
}