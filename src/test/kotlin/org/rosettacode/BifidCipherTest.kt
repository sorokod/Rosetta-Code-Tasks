package org.rosettacode

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BifidCipherTest : FunSpec({

    val square_abc_5x5 = Square("ABCDEFGHIKLMNOPQRSTUVWXYZ")
    val square_bgw_5x5 = Square("BGWKZQPNDSIOAXEFCLUMTHYVR")
    val square_abc_6x6 = Square("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789")

    fun assertIdentity(bifid: Bifid, text: String) = with(bifid) {
        decrypt(encrypt(text)) shouldBe text
    }


    test("square_abc_5x5") {
        with(Bifid(square_abc_5x5)) {
            encrypt("ATTACKATDAWN") shouldBe "DQBDAXDQPDQH"
            decrypt("DQBDAXDQPDQH") shouldBe "ATTACKATDAWN"

            assertIdentity(this, "ATTACKATDAWN")
        }
    }

    test("square_bgw_5x5") {
        with(Bifid(square_bgw_5x5)) {
            encrypt("FLEEATONCE") shouldBe "UAEOLWRINS"
            decrypt("UAEOLWRINS") shouldBe "FLEEATONCE"

            assertIdentity(this, "FLEEATONCE")
        }
    }

    test("square_abc_6x6") {
        with(Bifid(square_abc_6x6)) {
            encrypt("THEINVASIONWILLSTARTONTHEFIRSTOFJANUARY") shouldBe "TBPDIPHJSPOTAIVMGPCZKNSCN09BFIHK64I7BM4"
            decrypt("TBPDIPHJSPOTAIVMGPCZKNSCN09BFIHK64I7BM4") shouldBe "THEINVASIONWILLSTARTONTHEFIRSTOFJANUARY"

            assertIdentity(this, "THEINVASIONWILLSTARTONTHEFIRSTOFJANUARY")
        }
    }

})
