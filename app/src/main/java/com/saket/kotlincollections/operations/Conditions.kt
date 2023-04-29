package com.saket.kotlincollections.operations

/**
 * Here i look at 3 functions used to check conditions in a collection:
 * 1.Any 2.None 3.All
 *
 * Each of these functions takes a predicate which will return a
 * true/false based on the predicate.
 */
data class Person(
    val name: String,
    val age: Int,
    val hasDriversLicense: Boolean
)

val friendGroup = listOf(
    Person("Saket", 24, false),
    Person("Saurabh", 25, false),
    Person("Ajit", 25, true)
)

/*
Any returns true if there is at least one element in the predicate
which returns true
 */
val canSomeoneDrive = friendGroup.any { it.hasDriversLicense }
// true

/*
None checks if none of the elements in the the list satisfy the
predicate.
 */
val canEveryoneDrink = friendGroup.none { it.age < 18 }
// true

/*
All returns true if each element of the collection matches the
predicate.

Note: In case of an empty collection all will return
true, since there is no element which violates the predicate.
 */
val areAllNamesValid = friendGroup.all { it.name.length > 2 }
// true
