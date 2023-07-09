package org.rosettacode.sorting

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Using coroutines rather than threads. Negative numbers are obviously an issue.
 *
 * https://rosettacode.org/wiki/Sorting_algorithms/Sleep_sort#Using_coroutines
 */
fun sleepSort(list: List<Int>, delta: Long = 10): List<Int> {
    val result = mutableListOf<Int>()
    runBlocking {
        list.onEach {
            launch {
                delay(it * delta)
                result.add(it)
            }
        }
    }
    return result
}

fun main() {
    val list = listOf(5, 7, 2, 4, 1, 8, 0, 3, 9, 6)
    println("Unsorted: $list")
    print("Sorted  : ")
    sleepSort(list, 10).also { println(it) }

}
