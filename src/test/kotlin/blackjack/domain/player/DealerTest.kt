package blackjack.domain.player

import blackjack.domain.card.CardTest.Companion.SPADE_ACE
import blackjack.domain.card.CardTest.Companion.SPADE_FIVE
import blackjack.domain.card.CardTest.Companion.SPADE_JACK
import blackjack.domain.card.CardTest.Companion.SPADE_KING
import blackjack.domain.card.CardTest.Companion.SPADE_QUEEN
import blackjack.domain.card.CardTest.Companion.SPADE_THREE
import blackjack.domain.card.CardTest.Companion.SPADE_TWO
import blackjack.domain.card.Cards
import blackjack.domain.gamestate.finished.Bust
import blackjack.domain.gamestate.finished.Stay
import blackjack.domain.gamestate.running.Hit
import blackjack.domain.gamestate.running.InitialHand
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import java.lang.IllegalStateException

class DealerTest : FunSpec({

    context("draw") {
        test("카드 draw 시 17이 넘어가면 자동으로 Stay된다.") {
            val dealer = Dealer(gameState = Hit(Cards.of(SPADE_TWO, SPADE_KING)))
            dealer.draw(SPADE_FIVE)

            val actual = dealer.gameState
            actual.shouldBeTypeOf<Stay>()
        }

        test("카드 draw 시 21이 넘어가면 busgt된다.") {
            val dealer = Dealer(gameState = Hit(Cards.of(SPADE_TWO, SPADE_KING)))
            dealer.draw(SPADE_JACK)

            val actual = dealer.gameState
            actual.shouldBeTypeOf<Bust>()
        }

        test("카드 draw 시 17이 넘어가지 않으면 계속 Hit다.") {
            val dealer = Dealer(gameState = Hit(Cards.of(SPADE_TWO, SPADE_THREE)))
            dealer.draw(SPADE_FIVE)

            val actual = dealer.gameState
            actual.shouldBeTypeOf<Hit>()
        }
    }

    context("stay") {
        test("딜러가 stay하는 경우 예외가 발생한다.") {
            val dealer = Dealer(gameState = Hit(Cards.of(SPADE_TWO, SPADE_THREE)))
            val exception = shouldThrowExactly<IllegalStateException> { dealer.stay() }
            exception.message shouldBe "딜러는 직접 stay할 수 없다."
        }
    }

    context("cards") {
        test("모든 카드를 반환한다.") {
            val dealer = Dealer(gameState = Bust(Cards.of(SPADE_KING, SPADE_JACK, SPADE_QUEEN)))
            val actual = dealer.cards()
            actual shouldBe setOf(SPADE_KING, SPADE_JACK, SPADE_QUEEN)
        }
    }

    context("score") {
        test("턴이 종료되기 전에 점수 조회시 예외가 발생한다.") {
            val dealer = Dealer(gameState = InitialHand())
            val exception = shouldThrowExactly<IllegalStateException> { dealer.score() }
            exception.message shouldBe "턴이 종료되기 전에는 점수를 조회할 수 없다"
        }
    }

    context("competeWith") {
        test("승부확인을 하려하는 경우 예외가 발생한다.") {
            val dealer = Dealer(Stay(Cards.of(SPADE_ACE, SPADE_KING)))
            val player = Player(Name("최진영"), Money(10_000), Stay(Cards.of(SPADE_ACE, SPADE_KING)))

            val exception = shouldThrowExactly<IllegalStateException> { dealer.competeWith(player) }
            exception.message shouldBe "딜러는 승부할 수 없다."
        }
    }
})
