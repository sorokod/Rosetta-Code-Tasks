package rosettacode

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.rosettacode.splitOnChange

class SplitOnChangeTest : FunSpec({

    test("splitOnChange") {
        splitOnChange("""gHHH5YY++///\""") shouldBe """g, HHH, 5, YY, ++, ///, \"""
        splitOnChange("") shouldBe ""
    }
})
