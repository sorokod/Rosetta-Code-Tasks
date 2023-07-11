package org.rosettacode

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.Row2
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEmpty
import org.rosettacode.Outcome.Fail
import org.rosettacode.Outcome.Ok
import org.rosettacode.splitOnChange


class IBANTest : FunSpec({

    context("Testing validation") {

        Registry["GB"] = Validator("GB2!n4!a6!n8!n")
        Registry["DE"] = Validator("DE2!n8!n10!n")

        withData(
            mapOf(
                "OK GB" to row("GB82WEST12345698765432", Ok),
                "OK GB with spaces" to row("GB82 WEST 1234 5698 7654 32", Ok),
                "OK DE" to row("DE89370400440532013000", Ok),
                "FAIL XX" to row("XX82WEST1234569A765432", Fail("Unknown Country Code: XX")),
                "FAIL GB too short" to row("GB82", Fail("IBAN is too short")),
                "FAIL GB rule: [0-9]{8}" to row("GB82WEST1234569A765432", Fail("failed rule: [0-9]{8}")),
                "FAIL GB rule: [A-Z]{4}" to row("GB82WE5T1234569A765432", Fail("failed rule: [A-Z]{4}")),
                "FAIL GB too long" to row("GB82WEST123456987654329", Fail("IBAN is too long")),
                "FAIL GB invalid check digits" to row("GB80WEST12345698765432", Fail("Invalid Check Digits")),
            )
        ) { (input, expected) -> validate(input) shouldBe expected }
    }
})
