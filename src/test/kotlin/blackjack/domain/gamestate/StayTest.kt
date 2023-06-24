package blackjack.domain.gamestate

import blackjack.domain.card.CardTest.Companion.SPADE_ACE
import blackjack.domain.card.CardTest.Companion.SPADE_JACK
import blackjack.domain.card.CardTest.Companion.SPADE_KING
import blackjack.domain.card.CardTest.Companion.SPADE_QUEEN
import blackjack.domain.card.Cards
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StayTest : FunSpec({

    context("init") {
        test("생성시 카드가 initialhand면 예외가 발생한다.") {
            val exception = shouldThrowExactly<IllegalArgumentException> { Stay(Cards()) }
            exception.message shouldBe "2장 미만의 카드로 생성될 수 없다."
        }

        test("생성 시 카드가 bust면 예외가 발생한다.") {
            val exception =
                shouldThrowExactly<IllegalArgumentException> { Stay(Cards.of(SPADE_KING, SPADE_JACK, SPADE_QUEEN)) }
            exception.message shouldBe "버스트 카드로 생성될 수 없다."
        }
    }

    context("draw") {
        test("카드를 드로우하려는 경우 예외가 발생한다.") {
            val exception = shouldThrowExactly<IllegalStateException> { Stay(STAY_CARDS).draw(SPADE_ACE) }
            exception.message shouldBe "종료된 게임은 draw할 수 없다."
        }
    }

    context("stay") {
        test("카드를 그만 받으려하는 경우 예외가 발생한다.") {
            val exception = shouldThrowExactly<IllegalStateException> { Stay(STAY_CARDS).stay() }
            exception.message shouldBe "종료된 게임은 stay할 수 없다."
        }
    }

    context("isBust") {
        test("bust인지 확인한다") {
            val actual = Stay(STAY_CARDS).isBust()
            actual shouldBe false
        }
    }
}) {
    companion object {
        private val STAY_CARDS = Cards.of(SPADE_KING, SPADE_JACK)
    }
}
