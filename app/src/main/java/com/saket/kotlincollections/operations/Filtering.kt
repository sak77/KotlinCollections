package com.saket.kotlincollections.operations

/**
 * Each filtering operation generates a new list. This is
 * probably tied to the immutability function principle of
 * functional programming.
 */

val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

/*
filter takes a predicate and applies it to all elements of
a list. It returns only those elements that satisfy the predicate.
 */
val evenNumbers = numbers.filter { number -> number % 2 == 0 }
// [2, 4, 6, 8, 10]

/*
To test a negative condition, one can use filterNot. So it
returns all elements that do NOT satisfy the predicate.
 */
val oddNumbers = numbers.filterNot { number -> number % 2 == 0 }
// [1, 3, 5, 7, 9]

/*
Partition function returns 2 lists. First, which satisfies the
predicate and the next one which contains elements that do not
satisfy the predicate.
 */
val partitionedNumbers = numbers.partition { number -> number % 2 == 0 }
// ([2, 4, 6, 8, 10], [1, 3, 5, 7, 9])

/*
filterNotNull() discards null elements from the list and
returns a new list with only the non-null elements.
 */

/*
filterIsInstance<T>() can be used to filter elements of a
specific instance from a list that may contain elements of
different instances.
 */

/*
take(n) will return a list of first n elements of the collection.
 */

/*
drop(n) will drop the first n elements of the collection from the
returned list.
 */

/*
Use maxOrNull() or minOrNull() to get max or min values in a collection.
There is also a sibling function maxOf and minOf where you can pass
a lambda to calculate the input from the collections.
 */

/*
distinct() returns distinct list from a collection. It does not
however consider lowercase/uppercase condition.
 */
val fruits = listOf("Apple", "Banana", "Apple", "APPLE", "BANANA", "Durian")
val fruitBasket = fruits.distinct()
// [Apple, Banana, APPLE, BANANA, Durian]

/*
distinctBy allows to apply some map to each element before applying
distinct condition. So below i convert all elements to lowercase.
Before applying the distinct condition.
 */
val fruitBasket2 = fruits.distinctBy { it.lowercase() }
// [Apple, Banana, Durian]
// Note that the output still retains its case. So here, toLowercase()
// is only used for distinct comparison. But does not affect output.
