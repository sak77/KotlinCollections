package com.saket.kotlincollections.operations

import java.util.*

/**
 * Just like chunked and windowed functions can be used to
 * split a collection. Similarly there are functions like zip
 * which can combine two collections.
 */
class Combine {
    val names = listOf("Saket", "Aniket", "Vishket")
    val ages = listOf("39", "38", "34")

    /*
    The plus operator simply appends two lists
     */
    val plusOperator = names + ages
    // [Saket, Aniket, Vishket, 39, 38, 34]

    /*
    Zip function will bind elements at the respective index.
     */
    val zipFunction = names.zip(ages)
    // [(Saket, 39), (Aniket, 38), (Vishket, 34)]

    /*
    Zip function also can be inlined.
     */
    val zipInlined = names zip ages
    // [(Saket, 39), (Aniket, 38), (Vishket, 34)]

    /*
    Zip also provides a lambda to perform some transformation
    on the elements.
     */
    val transformedZip = names.zip(ages) { name, age ->
        name.uppercase() to age.toInt() + 1
    }
    // [(SAKET, 40), (ANIKET, 39), (VISHKET, 35)]

    /*
    Unzip can do opposite of zip
     */
    val unzip = transformedZip.unzip()
    // ([SAKET, ANIKET, VISHKET], [40, 39, 35])

    /*
    zipWithNext will zip each element of the list with the
    next element in the same list. It can be considered a special
    case of the windowed function.
     */

    val ageNumber = listOf(39, 38, 34)
    val ageDiff = ageNumber.zipWithNext { a, b ->
        a - b
    }
    // [1, 4]

    /*
    Kotlin by default provides some collection functions like sum() or aggregate() to
    reduce a collection to a single value. But if we want to perform our own operation
    on a collection, we can use the reduce function.
    Reduce a list to a single value based on some operations. It accepts a function with
    2 parameters, acc (accumulator) and value at each index in the list.
    Initial value is assigned to acc, and operation is performed with next value and
    the result is stored again in the acc. There are other flavors of reduce function,
    like reduceRight, reduceOrNull.
     */
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val result = numbers.reduce { acc, value -> acc * value }
    // 3628800

    /*
    Fold is another reduce function. It functions similarly to reduce. Except that
    we get to specify the initial value and type. foldRight is another flavor of fold function.
     */
    val fold = numbers.fold(1) { acc, value -> value - acc }
    // 6

    /*
    RunningFold and Running reduce do not return just a single value of the accumulator,
    but a sequence of values for each iteration of the accumulator.
     */
    val runningFold = numbers.runningFold(1) { acc, value -> value - acc }
    // [1, 0, 2, 1, 3, 2, 4, 3, 5, 4, 6]
}
