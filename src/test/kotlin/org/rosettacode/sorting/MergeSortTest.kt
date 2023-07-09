package org.rosettacode.sorting

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MergeSortTest : FunSpec({
    test("should sort") {
        val unsorted = listOf(5, 7, 2, 4, 1, 8, 0, 3, 9, 6, -1)
        val expected = listOf(-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

        mergeSort(unsorted) shouldBe expected
    }


})
