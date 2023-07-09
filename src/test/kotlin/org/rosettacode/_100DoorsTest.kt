package org.rosettacode

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class _100DoorsTest : FunSpec({

    test("100 doors") {
        val expected = listOf(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

        oneHundredDoors() shouldBe expected
    }

})
