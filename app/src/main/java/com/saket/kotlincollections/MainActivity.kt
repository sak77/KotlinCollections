package com.saket.kotlincollections

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi

/**
 * Kotlin provides 3 types of collections -
 * list, set and map.
 *
 * Collection interface extends iterable interface.
 *
 * Each collection type has 2 implementations, a read-only type and a mutable type.
 *
 * In this project i will go hands-on while referring to -
 * https://kotlinlang.org/docs/collections-overview.html
 */
class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        //Since collection extends iterable interface, so they support looping though its elements.
        println("Saket Todo list:\n")
        getTasksList()
            .forEach { println("Todo: $it\n") }

        //Mutable list allows us to add/remove/replace elements in the collection.
        val completedList = getCompletedTasksList()
        completedList.add("Buy Grocery")

        println("Saket Completed list:\n")
        completedList.forEach {
            println("Completed: $it\n")
        }
*/
/*
        println("Saket days of the week:\n")
        getDaysOfTheWeek()
            //.parallelStream()     //Makes stream emit items asynchronously
            .map { day -> day.uppercase() }
            .forEach { println("$it") }
*/

        //Map gives many methods to retrieve key/values of elements
/*
        val familyDetails = getFamilyDetails()
        println("Family members : ${familyDetails.keys}")
        println("Personnummers : ${familyDetails.values}")
*/

        //Two maps containing the equal pairs are equal regardless of the pair order.

        //Mutable maps
        /*
        MutableMap is a Map with map write operations, for example,
        you can add a new key-value pair or update the value associated with the given key.
         */
/*
        val numbersMap = mutableMapOf("one" to 1, "two" to 2)

        numbersMap.put("three", 3)
        numbersMap["one"] = 11

        println(numbersMap)
*/
        val mySequences = Sequences()
        mySequences.testSequences()
    }

    /*
        List can be an indexed collection. It can hold duplicate values as well.
        Returns read-only list. No item can be added/removed/updated in the list.

        In Kotlin, the default implementation of List is ArrayList which you can think of as a resizable array.
     */
    fun getTasksList() = listOf("Exercise", "Study", "Fix bike", "Clean house", "Play", "Exercise")

    //Returns mutable list.
    fun getCompletedTasksList() = mutableListOf("Wash clothes", "Return books")

    /*
    Returns set (read-only) of days of the week.
    Set is a collection of unique elements. It can contain only one null item.

    Here although the set contains 2 instances of Sunday, but when it prints out the values, it only
    returns one Sunday. Thus removing any duplicate values.

    Similarly you can use mutableSetOf() to get a set that supports add/remove/replace operations.

    The default implementation of Set – LinkedHashSet – preserves the order of elements insertion.
    Hence, the functions that rely on the order,
    such as first() or last(), return predictable results on such sets.

    An alternative implementation – HashSet – says nothing about the elements order,
    so calling such functions on it returns unpredictable results.
    However, HashSet requires less memory to store the same number of elements.
     */
    fun getDaysOfTheWeek() = setOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
        "Sunday")

    /*
    Map<K, V> is not an inheritor of the Collection interface;
    however, it's a Kotlin collection type as well.

    The default implementation of Map – LinkedHashMap – preserves the order of elements insertion when iterating the map.
    In turn, an alternative implementation – HashMap – says nothing about the elements order.
     */
    fun getFamilyDetails() = mapOf("Saket" to "8307189251", "Sweta" to "8811290504",
        "Bunny" to "1609300155", "Daddy" to "5001131111", "Mummy" to "5911010000",
        "Aniket" to "8408274321", "Vishket" to "8903081234")


}