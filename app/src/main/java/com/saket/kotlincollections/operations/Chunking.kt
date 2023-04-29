package com.saket.kotlincollections.operations

/**
 * Collections provide functions called chunked/windowed which breaks it into
 * parts of specified size.
 */
val objects = listOf(":)", ":/", ":|", ":D", ":(", ":*")

val chunkedObjects = objects.chunked(3)
// [[":)", ":/", ":|"], [":D", ":(", ":*"]]

// chunked also allows to transform the collection using lambda.
val chunkedObjectsReversed = objects.chunked(3) {
    it.reversed()
}
// [[":*", ":(", ":D"], [":|", ":/", ":)"]]

/*
A windowed collection also cuts a list like chunked. But instead
of returning a list of lists, it gives a sliding window view of
the collection. So there is some overlap between the sub-lists.
 */
val windowedObjects = objects.windowed(3)
// [[":)", ":/", ":|"], [":/", ":|", ":D"], [":|", ":D", ":("], [":D", ":(", ":*"]]

/*
By default the step size for windowed function is 1. But we can
specify our own step size. PartialWindows is a parameter to allow
the last leftover elements into the windowed collection.
 */
val windowedObjects2 = objects.windowed(3, 2, true)
// [[":)", ":/", ":|"], [":|", ":D", ":("], [":(", ":*"]]

/*
Just like chunked, windowed also allows to perform additional tranformation using
lambda.
 */
val windowedObjectsReversed = objects.windowed(3) {
    it.reversed()
}

/*
Flatten is opposite of windowed/chunked functions. Which means instead of splitting a
list into sub lists. It merges the list into one list.
 */
val windowedObjects2Flattened = objects.windowed(3, 2, true).flatten()
// [":)", ":/", ":|",":|", ":D", ":(",":(", ":*"]

/*
FlatMap is combination of first using a transformation map and then flatten function on the list.
 */
val names = listOf("Saket", "Aniket", "Vishket").flatMap {
    it.toList()
}
// ['S','a','k','e','t','A','n','i','k','e','t','V','i','s','h','k','e','t']
