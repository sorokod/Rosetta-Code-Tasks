package org.rosettacode

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.Row2
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEmpty
import org.rosettacode.splitOnChange


class SplitOnChangeTest : FunSpec({

    context("Testing splitting") {
        withData(
            mapOf(
                "test original" to row("""gHHH5YY++///\""", """g, HHH, 5, YY, ++, ///, \"""),
                "test hello" to row("""hello""", """h, e, ll, o"""),
                "test empty" to row("", ""),
            )
        ) { (input, expected) ->
            splitOnChange(input) shouldBe expected
        }
    }

})
